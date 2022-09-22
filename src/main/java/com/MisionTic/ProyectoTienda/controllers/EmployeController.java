package com.MisionTic.ProyectoTienda.controllers;
import com.MisionTic.ProyectoTienda.Interfaces.IEmployeService;
import com.MisionTic.ProyectoTienda.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("views/employe")
public class EmployeController {

    @Autowired
    private IEmployeService employeService;

    @GetMapping("/")
    public String listar (Model model)
    {
        List<Employe> employe = employeService.list();
        model.addAttribute("titulo", "Empleados");
        model.addAttribute("employe", employe);
        return "views/employe/listar";
    }

    @GetMapping("/crear")
    public String crear (Model model){
        Employe employe = new Employe();
        model.addAttribute("titulo", "Nuevo Empleado");
        model.addAttribute("employe", employe);
        return "views/employe/crear";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Employe employe){
        employeService.guardar(employe);
        return "redirect:/views/employe/";
    }

    @GetMapping("/editar/{id}")
    public String searchById (@PathVariable("id") Long idEmploye, Model model){
        Employe employe = employeService.searchById(idEmploye);
        model.addAttribute("titulo", "Actualizar Empleado");
        model.addAttribute("employe", employe);
        return "views/employe/crear";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar (@PathVariable("id") Long idEmploye){
        employeService.eliminar(idEmploye);
        System.out.println("Registro eliminado con exito");
        return "redirect:/views/employe/";
    }
}
