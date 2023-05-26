package com.miempresa.tecnologiaventas.com.tecnologiaventas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao.IProductoDao;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Producto;

@Controller
@SessionAttributes("producto")
public class ProductoController {
    @Autowired
    private IProductoDao productoDao;

    @GetMapping("/ProductoListar")
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Productos");
        model.addAttribute("producto", productoDao.findAll());

        return "ProductoListar";
    }

    @GetMapping("/ProductoForm")
    public String crear(Model model){
        Producto producto = new Producto();
        model.addAttribute("titulo", "Formulario de Productos");
        model.addAttribute("titulo", "Formulario Para Registrar Producto");
        model.addAttribute("producto", producto);
        model.addAttribute("button", "Crear Productos");

        return "ProductoForm";
    }
    
    @PostMapping("/ProductoForm")
    public String guardar(Producto producto, SessionStatus status){
        System.out.println("Guardando Producto");
        productoDao.save(producto);
        status.setComplete();
        return "redirect:/ProductoListar";
    }

    @GetMapping("/ProductoForm/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Producto producto = null;
        System.out.println("****" + id);
        if (id > 0) {
            producto = productoDao.findOne(id);
            System.out.println("****"+id);
        } else {
            return "redirect:/ProductoListar";
        }

        model.addAttribute("titulo", "Editar Producto");
        
        model.addAttribute("titulo", "Editar Producto");
        model.addAttribute("producto", producto);
        model.addAttribute("button", "Guardar Cambios");

        return "ProductoForm";
    }
    
    @GetMapping("/eliminarProducto/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        if (id > 0) 
            productoDao.delete(id);
            System.out.println("Ingrese al Eliminar Usuario" + id);
        
        return "redirect:/ProductoListar";
    }
}
