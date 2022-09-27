package com.MisionTic.ProyectoTienda.controllers;

import com.MisionTic.ProyectoTienda.Interfaces.IProfileService;
import com.MisionTic.ProyectoTienda.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/views/profile")
public class ProfileController
{
    @Autowired
    private IProfileService profileService;

    @GetMapping("/")
    public String listara(Model model)
    {
        List<Profile> listados=profileService.lista();
        model.addAttribute("titulo","Perfiles");
        model.addAttribute("profile",listados);
        return "views/profile/listara";
    }

    @GetMapping("/crea")
    public String crea(Model model)
    {
        Profile profile=new Profile();
        model.addAttribute("titulo","Nuevo Perfil");
        model.addAttribute("profile",profile);
        return "views/profile/frmcrea";
    }
    @PostMapping("/save")
    public String guardara(@ModelAttribute Profile profile)
    {
        profileService.guarda(profile);
        return "redirect:/views/profile/";
    }

    @GetMapping("/edit/{id}")
    public String editara(@PathVariable("id") Long idProfile, Model model)
    {
        Profile profile=profileService.buscarporID(idProfile);
        model.addAttribute("titulo","Editar Perfil");
        model.addAttribute("profile", profile);
        return "views/profile/frmcrea";
    }

    @GetMapping("/delete/{id}")
    public String eliminara(@PathVariable("id") Long idProfile)
    {
        profileService.elimina(idProfile);
        return "redirect:/views/profile/";
    }
}
