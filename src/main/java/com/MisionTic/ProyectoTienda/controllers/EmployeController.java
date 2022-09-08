package com.MisionTic.ProyectoTienda.controllers;

import com.MisionTic.ProyectoTienda.entities.Employe;
import com.MisionTic.ProyectoTienda.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping
public class EmployeController {
    @Autowired
    private EmployeService service;
    @GetMapping("/listar")
    public String listar(Model model){
        List<Employe> employes = service.getData();
        model.addAttribute("employes", employes);
        return "index";
    }

}
