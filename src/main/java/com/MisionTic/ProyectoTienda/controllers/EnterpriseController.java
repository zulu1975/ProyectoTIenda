package com.MisionTic.ProyectoTienda.controllers;

import com.MisionTic.ProyectoTienda.entities.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping("/views/enterprises")
public class EnterpriseController {
    //Aqui estamos inyectando las dependencias hacia el servicio
    @Autowired
    private IEnterpriseService enterpriseService;

    /**
     * Método para listar las empresas
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

    /**
     * Método para crear las empresas
     * @param model
     * @return
     */
    @GetMapping("/create")
    public String createEnterprise(Model model){
        Enterprise enterprise = new Enterprise();
        model.addAttribute("titulo", "Crear Empresa");
        model.addAttribute("enterprise", enterprise);
        return "views/enterprises/createEnterprise";
    }

    /**
     * Método para guardar las empresas
     * @param enterprise
     * @return
     */

    @PostMapping("/save")
    public String saveEnterprise(@ModelAttribute Enterprise enterprise){
        enterpriseService.save(enterprise);
        return "redirect:/views/enterprises/";
    }

    /**
     * Método para actualizar los datos de una empresa
     * @param idEnterprise
     * @param model
     * @return
     */
    @GetMapping("/update/{id}")
    public String updateEnterprise(@PathVariable("id") Long idEnterprise, Model model){
        Enterprise enterprise = enterpriseService.searchById(idEnterprise);
        model.addAttribute("titulo", "Actualizar Empresa");
        model.addAttribute("enterprise", enterprise);
        return "views/enterprises/createEnterprise";
    }

    @GetMapping("/delete/{id}")
    public String deleteEnterprise(@PathVariable("id") Long idEnterprise){
        enterpriseService.delete(idEnterprise);
        System.out.println("Registro eliminado con exito");
        return "redirect:/views/enterprises/";
    }
}
