package com.MisionTic.ProyectoTienda.controllers;

import com.MisionTic.ProyectoTienda.Interfaces.ITransactionService;
import com.MisionTic.ProyectoTienda.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/views/transaction")
public class TransactionController
{
    @Autowired
    private ITransactionService transactionService;

    @GetMapping("/")
    public String listar(Model model)
    {
        List<Transaction> Listado=transactionService.listas();
        model.addAttribute("titulo","listados");
        model.addAttribute("transaction",Listado);
        return "views/transaction/listar";

    }

    @GetMapping("/crear")
    public String crear(Model model)
    {
        Transaction transaction=new Transaction();
        model.addAttribute("titulo","nuevo");
        model.addAttribute("transaction",transaction);
        return "views/transaction/frmcrear";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Transaction transaction)
    {
         transactionService.guardar(transaction);
         return "redirect:/views/transaction/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idTransaction, Model model)
    {
        Transaction transaction=transactionService.buscarporId(idTransaction);
        model.addAttribute("titulo","editar");
        model.addAttribute("transaction",transaction);
        return "views/transaction/frmcrear";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idTransaction)
    {
        transactionService.eliminar(idTransaction);
        return "redirect:/views/transaction/";
    }



}
