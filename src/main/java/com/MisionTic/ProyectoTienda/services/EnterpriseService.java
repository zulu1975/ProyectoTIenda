package com.MisionTic.ProyectoTienda.services;

import com.MisionTic.ProyectoTienda.Interfaces.IEnterpriseService;
import com.MisionTic.ProyectoTienda.entities.Enterprise;
import com.MisionTic.ProyectoTienda.repositories.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService implements IEnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Override
    public List<Enterprise> listar() {
        return (List<Enterprise>) enterpriseRepository.findAll();
    }

    @Override
    public void guardar(Enterprise enterprise) {
        enterpriseRepository.save(enterprise);
    }

    @Override
    public Enterprise buscarId(Long id) {
        return enterpriseRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        enterpriseRepository.deleteById(id);

    }
}
