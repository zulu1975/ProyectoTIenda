package com.MisionTic.ProyectoTienda.services;

import com.MisionTic.ProyectoTienda.entities.Rol;
import com.MisionTic.ProyectoTienda.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> listar(){
        return (List<Rol>) rolRepository.findAll();
    }
}
