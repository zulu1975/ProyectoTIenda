package com.MisionTic.ProyectoTienda.controllers;

import com.MisionTic.ProyectoTienda.entities.Enterprise;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnterpriseController {

    @GetMapping("/saludar")
    public Enterprise test(){
        Enterprise en1 = new Enterprise(01,"SEQUAL","12345","4449870","Medellin");
        return en1;

    }
}
