package com.miempresa.tecnologiaventas.com.tecnologiaventas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("inicio")
public class InicioController {
    @GetMapping("/Inicio")
    public String inicio(Model Model)
    {
        
        System.out.println("Ingresamos al Inicio");
        return "Inicio";
    }

    // @GetMapping("/Inicio")
    // public String MenuProveedorProveedor() {
        
    //     return "Login";
    // }
}
