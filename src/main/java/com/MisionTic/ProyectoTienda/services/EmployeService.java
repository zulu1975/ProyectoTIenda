package com.MisionTic.ProyectoTienda.services;

import com.MisionTic.ProyectoTienda.Interfaces.IEmployeService;
import com.MisionTic.ProyectoTienda.entities.Employe;
import com.MisionTic.ProyectoTienda.entities.Enterprise;
import com.MisionTic.ProyectoTienda.repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService implements IEmployeService {

    @Autowired
    private EmployeRepository employeRepository;
    @Override
    public List<Employe> getAll() {
        return (List<Employe>) employeRepository.findAll();
    }

    @Override
    public void save(Employe employe) {
        employeRepository.save(employe);
    }

    @Override
    public Employe searchById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        employeRepository.deleteById(id);
    }
}
