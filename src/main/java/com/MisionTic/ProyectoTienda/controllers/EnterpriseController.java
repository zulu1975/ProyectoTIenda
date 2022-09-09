package com.MisionTic.ProyectoTienda.controllers;

import com.MisionTic.ProyectoTienda.entities.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/views/enterprises")
public class EnterpriseController {
    //Aqui estamos inyectando las dependencias hacia el servicio
    @Autowired
    private IEnterpriseService enterpriseService;

    /**
     * Metodo para listar las empresas
     * @param model
     * @return
     */
    @GetMapping("/")
    public String getEnterpriseAll(Model model){
        List<Enterprise> enterprises = enterpriseService.getAll();
        model.addAttribute("titulo", "Empresas");
        model.addAttribute("enterprises", enterprises);
        return "views/enterprises/listEnterprise";
    }

    @GetMapping("/create")
    public String createEnterprise(Model model){
        Enterprise enterprise = new Enterprise();
        model.addAttribute("enterprise", enterprise);
        return "views/enterprises/createEnterprise";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Enterprise enterprise){
        enterpriseService.save(enterprise);
        return "redirect:/views/enterprises/";
    }
}
