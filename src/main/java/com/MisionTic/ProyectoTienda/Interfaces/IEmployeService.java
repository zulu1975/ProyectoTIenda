package com.MisionTic.ProyectoTienda.Interfaces;

import com.MisionTic.ProyectoTienda.entities.Employe;

import java.util.List;

public interface IEmployeService {
        public List<Employe> list();
        public void guardar(Employe employe);
        public Employe searchById (Long id);
        public void eliminar(Long id);
}
