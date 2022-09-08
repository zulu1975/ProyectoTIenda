package com.MisionTic.ProyectoTienda.services;

import com.MisionTic.ProyectoTienda.entities.Employe;
import com.MisionTic.ProyectoTienda.repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeService {

    @Autowired
    private EmployeRepository data;

    public List<Employe> getData(){
        return (List<Employe>)data.findAll();
    }
}
