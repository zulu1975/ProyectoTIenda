package com.MisionTic.ProyectoTienda.controllers;

import com.MisionTic.ProyectoTienda.Interfaces.IEmployeService;
import com.MisionTic.ProyectoTienda.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping
public class EmployeController {

    @Autowired
    private IEmployeService employeService;

    @GetMapping("/")
    public String getEmployeAll(Model model){
        List<Employe> employe = employeService.getAll();
        model.addAttribute("titulo", "Employe");
        model.addAttribute("employe", employe);
        return "views/employe/listEmploye";
    }

    @GetMapping("/create")
    public String createEmploye(Model model){
        Employe employe = new Employe();
        model.addAttribute("employe", employe);
        return "views/employe/createEmploye";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employe employe){
        employeService.save(employe);
        return "redirect:/views/employe/";
    }

}
