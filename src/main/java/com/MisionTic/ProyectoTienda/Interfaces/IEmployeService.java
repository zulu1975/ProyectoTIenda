package com.MisionTic.ProyectoTienda.Interfaces;

import com.MisionTic.ProyectoTienda.entities.Employe;

import java.util.List;

public interface IEmployeService {
        public List<Employe> getAll();
        public void save(Employe employe);
        public Employe searchById(Long id);
        public void delete(Long id);
}
