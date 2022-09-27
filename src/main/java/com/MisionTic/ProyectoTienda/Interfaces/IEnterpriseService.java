package com.MisionTic.ProyectoTienda.Interfaces;

import com.MisionTic.ProyectoTienda.entities.Enterprise;

import java.util.List;

public interface IEnterpriseService {

    public List<Enterprise> listar();
    public void  guardar(Enterprise enterprise);
    public Enterprise buscarId(Long id);
    public void eliminar(Long id);
}
