package com.MisionTic.ProyectoTienda.controllers;
import antlr.StringUtils;
import com.MisionTic.ProyectoTienda.Interfaces.IEmployeService;
import com.MisionTic.ProyectoTienda.Interfaces.IEnterpriseService;
import com.MisionTic.ProyectoTienda.Interfaces.IProfileService;
import com.MisionTic.ProyectoTienda.entities.Employe;
import com.MisionTic.ProyectoTienda.entities.Enterprise;
import com.MisionTic.ProyectoTienda.entities.EnumRole;
import com.MisionTic.ProyectoTienda.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.xpath.XPath;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("views/employe")
public class EmployeController {

    @Autowired
    private IEmployeService employeService;
    @Autowired
    private IEnterpriseService enterpriseService;
    @Autowired
    private IProfileService profileService;

    @GetMapping("/")
    public String listar (Model model){
        List<Employe> listEmployee = employeService.list();
        model.addAttribute("titulo", "Empleados");
        model.addAttribute("employee", listEmployee);
        return "views/employe/listar";
    }

    @GetMapping("/crear")
    public String crear (Model model){
        Employe employe = new Employe();
        List<Enterprise> listEnterprise = enterpriseService.listar();
        model.addAttribute("titulo", "Nuevo Empleado");
        model.addAttribute("employe", employe);
        model.addAttribute("enterprise", listEnterprise);
        model.addAttribute("enumRole", EnumRole.values());
        return "views/employe/crear";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Employe employe, @RequestParam("file")MultipartFile imagen) {
       employeService.guardar(employe);
        if (!imagen.isEmpty()){
            //ruta relativa
            Path directorioImagenes= Paths.get("src//main//resources/img");
            //ruta bsoluta
            String rutaAbsoluta=directorioImagenes.toFile().getAbsolutePath();

            try {
                byte[] bytesImg=imagen.getBytes();
                Path rutaCompleta=Paths.get(rutaAbsoluta+"//"+imagen.getOriginalFilename());
                Files.write(rutaCompleta,bytesImg);
                employe.setImage(imagen.getOriginalFilename());
                //transaction.setImage(imagen.getOriginalFilename());
            } catch (IOException e){
                e.printStackTrace();
            }
        }


        return "redirect:/views/employe/";
    }

    @GetMapping("/editar/{id}")
    public String searchById (@PathVariable("id") Long idEmploye, Model model){
        Employe employe = employeService.searchById(idEmploye);
        List<Enterprise> listEnterprise = enterpriseService.listar();
        List<Profile> listProfile = profileService.lista();
        model.addAttribute("titulo", "Actualizar Empleado");
        model.addAttribute("employe", employe);
        model.addAttribute("enterprise", listEnterprise);
        model.addAttribute("enumRole", EnumRole.values());
        return "views/employe/crear";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar (@PathVariable("id") Long idEmploye){
        employeService.eliminar(idEmploye);
        System.out.println("Registro eliminado con exito");
        return "redirect:/views/employe/";
    }
}
