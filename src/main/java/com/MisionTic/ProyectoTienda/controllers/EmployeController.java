package com.MisionTic.ProyectoTienda.controllers;

import com.MisionTic.ProyectoTienda.Interfaces.IEmployeService;
import com.MisionTic.ProyectoTienda.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("employe")
public class EmployeController {
    //Aqui estamos inyectando las dependencias hacia el servicio
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
        model.addAttribute("titulo", "Crear Empleado");
        model.addAttribute("employe", employe);
        return "views/employe/createEmploye";
    }

    @PostMapping("/save")
    public String saveEmploye(@ModelAttribute Employe employe){
        employeService.save(employe);
        return "redirect:/views/employe/";
    }

    @GetMapping("/update/{id}")
    public String updateEmploye(@PathVariable("id") Long idEmploye, Model model){
        Employe employe = employeService.searchById(idEmploye);
        model.addAttribute("titulo", "Actualizar Empleado");
        model.addAttribute("employe", employe);
        return "views/employe/createEmploye";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmploye(@PathVariable("id") Long idEmploye){
        employeService.delete(idEmploye);
        System.out.println("Registro eliminado con exito");
        return "redirect:/views/employe/";
    }
}
