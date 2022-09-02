package com.MisionTic.ProyectoTienda.services;

import com.MisionTic.ProyectoTienda.Interfaces.IEnterpriseService;
import com.MisionTic.ProyectoTienda.entities.Enterprise;
import com.MisionTic.ProyectoTienda.repositories.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService implements IEnterpriseService {

    //Aqui estamos inyectando las dependencias hacia el repositorio
    @Autowired
    private EnterpriseRepository enterpriseRepository;


    @Override
    public List<Enterprise> getAll() {
        return (List<Enterprise>) enterpriseRepository.findAll();
    }

    @Override
    public void save(Enterprise enterprise) {
        enterpriseRepository.save(enterprise);
    }

    @Override
    public Enterprise searchById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
