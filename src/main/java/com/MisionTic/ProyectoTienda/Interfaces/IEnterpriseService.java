package com.MisionTic.ProyectoTienda.Interfaces;

import com.MisionTic.ProyectoTienda.entities.Enterprise;

import java.util.List;

public interface IEnterpriseService {
    public List<Enterprise> getAll();
    public void save(Enterprise enterprise);
    public Enterprise searchById(Long id);
    public void delete(Long id);
}
