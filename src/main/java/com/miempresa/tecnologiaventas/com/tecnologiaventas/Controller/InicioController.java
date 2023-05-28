package com.miempresa.tecnologiaventas.com.tecnologiaventas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("inicio")
public class InicioController {
    @GetMapping("General/Inicio")
    public String inicio(Model Model)
    {
        
        System.out.println("Ingresamos al Inicio");
        return "General/Inicio";
    }
}
