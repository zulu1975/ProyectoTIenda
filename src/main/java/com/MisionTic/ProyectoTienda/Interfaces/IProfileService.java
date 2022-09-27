package com.MisionTic.ProyectoTienda.Interfaces;

import com.MisionTic.ProyectoTienda.entities.Profile;

import java.util.List;

public interface IProfileService
{
    public List<Profile>lista();
    public void guarda(Profile profile);
    public Profile buscarporID(Long id);
    public void elimina(Long id);
}
