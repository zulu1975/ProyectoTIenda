package com.MisionTic.ProyectoTienda.services;

import com.MisionTic.ProyectoTienda.Interfaces.IProfileService;
import com.MisionTic.ProyectoTienda.entities.Profile;
import com.MisionTic.ProyectoTienda.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService implements IProfileService
{
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Profile> lista() {
        return (List<Profile>) profileRepository.findAll();
    }

    @Override
    public void guarda(Profile profile) {
        profileRepository.save(profile);

    }

    @Override
    public Profile buscarporID(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    @Override
    public void elimina(Long id) {
        profileRepository.deleteById(id);
    }
}
