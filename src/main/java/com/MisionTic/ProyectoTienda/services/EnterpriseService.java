package com.MisionTic.ProyectoTienda.services;

import com.MisionTic.ProyectoTienda.entities.Enterprise;
import com.MisionTic.ProyectoTienda.repositories.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository data;

    public List<Enterprise> getData(){
        return (List<Enterprise>)data.findAll();
    }


}
