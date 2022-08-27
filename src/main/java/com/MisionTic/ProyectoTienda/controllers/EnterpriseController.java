package com.MisionTic.ProyectoTienda.controllers;

import com.MisionTic.ProyectoTienda.entities.Enterprise;
import com.MisionTic.ProyectoTienda.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping
public class EnterpriseController {

    @Autowired
    private EnterpriseService service;
    @GetMapping("/listar")
    public String listar(Model model){
        List<Enterprise> enterprises = service.getData();
        model.addAttribute("enterprises", enterprises);
        return "index";
    }
}
