package com.miempresa.tecnologiaventas.com.tecnologiaventas.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao.InterfaceCRUD;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.DetalleOrden;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Orden;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Producto;

@Controller
@SessionAttributes("venta")
public class VentaController {

    private final Logger LOGGER = LoggerFactory.getLogger(VentaController.class);

    @Autowired
    private InterfaceCRUD<Producto> productoDao;

    //Para almacenar los detalles de la orden
    List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

    //Datos de la orden
    Orden orden = new Orden();

    @GetMapping("/VentaForm")
    public String inicio(Model Model)
    {
        System.out.println("Ingresamos a las Ventas para el Usuario");
        return "VentaForm";
    }

    @GetMapping("CRUDs/VentaForm")
    public String listar(Model model) {
        // model.addAttribute("titulo", "Carrito de Compras");
        // model.addAttribute("producto", productoDao.findAll());

        return "CRUDs/VentaForm";
    }

    // @GetMapping("/VentaForm")
    // public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad){

    //     return "/VantaForm";
    // }
}
