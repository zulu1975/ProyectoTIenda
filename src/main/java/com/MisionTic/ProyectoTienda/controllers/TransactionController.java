package com.MisionTic.ProyectoTienda.controllers;
import com.MisionTic.ProyectoTienda.Interfaces.IEmployeService;
import com.MisionTic.ProyectoTienda.Interfaces.IEnterpriseService;
import com.MisionTic.ProyectoTienda.Interfaces.ITransactionService;
import com.MisionTic.ProyectoTienda.entities.Employe;
import com.MisionTic.ProyectoTienda.entities.Enterprise;
import com.MisionTic.ProyectoTienda.entities.Transaction;
import com.MisionTic.ProyectoTienda.services.TransactionServices;
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

    @Autowired
    private TransactionServices transactionServices;

    @Autowired
    private IEmployeService employeService;
    @Autowired
    private IEnterpriseService enterpriseService;

    @GetMapping("/")
    public String listar(Model model)
    {
        List<Transaction> listTransaction = transactionService.listas();
        try{
            float suma = transactionServices.suma();
            model.addAttribute("suma",suma);

        }catch (Exception e){
            e.getMessage();
        }
        model.addAttribute("titulo","Transacciones");
        model.addAttribute("transaction",listTransaction);
        return "views/transaction/listar";

    }

    @GetMapping("/crear")
    public String crear(Model model)
    {
        Transaction transaction=new Transaction();
        Employe employee = employeService.searchById(1L);
        Enterprise enterprise = enterpriseService.buscarId(1L);
        model.addAttribute("titulo","Nueva Transacción");
        model.addAttribute("transaction",transaction);
        model.addAttribute("employee", employee);
        model.addAttribute("enterprise", enterprise);
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
        Employe employee = employeService.searchById(1L);
        Enterprise enterprise = enterpriseService.buscarId(1L);
        model.addAttribute("titulo","Editar Transacción");
        model.addAttribute("transaction",transaction);
        model.addAttribute("employee", employee);
        model.addAttribute("enterprise", enterprise);
        return "views/transaction/frmcrear";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idTransaction)
    {
        transactionService.eliminar(idTransaction);
        return "redirect:/views/transaction/";
    }



}
