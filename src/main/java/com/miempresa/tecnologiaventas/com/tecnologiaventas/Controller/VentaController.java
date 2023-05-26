package com.miempresa.tecnologiaventas.com.tecnologiaventas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("venta")
public class VentaController {
    @GetMapping("/VentaForm")
    public String inicio(Model Model)
    {
        
        System.out.println("Ingresamos a las Ventas para el Usuario");
        return "VentaForm";
    }
}
