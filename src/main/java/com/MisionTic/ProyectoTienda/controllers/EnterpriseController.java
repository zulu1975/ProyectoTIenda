package com.MisionTic.ProyectoTienda.controllers;

import com.MisionTic.ProyectoTienda.entities.Enterprise;
import com.MisionTic.ProyectoTienda.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/views/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/")
    public String  listar(Model model){
        List<Enterprise> enterprise = enterpriseService.listar();
        model.addAttribute("titulo","Listar Empresas");
        model.addAttribute("enterprise", enterprise);
        return "views/enterprise/listar";
    }
    @GetMapping("/crear")
    public String crear(Model model){
        Enterprise enterprise = new Enterprise();
        model.addAttribute("titulo","Crear Empresa");
        model.addAttribute("enterprise", enterprise);
        return "views/enterprise/crear";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Enterprise enterprise){
        enterpriseService.guardar(enterprise);
        return "redirect:/views/enterprise/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long idEnterprise, Model model){
        Enterprise enterprise = enterpriseService.buscarId(idEnterprise);
        model.addAttribute("titulo", "Editar Empresa");
        model.addAttribute("enterprise", enterprise);
        return "views/enterprise/crear";

    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long idEnterprise){
        enterpriseService.eliminar(idEnterprise);
        return "redirect:/views/enterprise/";
    }


}
