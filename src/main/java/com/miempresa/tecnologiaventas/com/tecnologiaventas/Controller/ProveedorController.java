package com.miempresa.tecnologiaventas.com.tecnologiaventas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao.IContactoInfo;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao.IProveedorDao;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Proveedor;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.ProveedorJoinContacto;

//Corregir todo a proveedor

@Controller
@SessionAttributes("proveedor")
public class ProveedorController {
    @Autowired
    private IProveedorDao proveedorDao;
    
    @Autowired 
    private IContactoInfo contactoDao;

    @GetMapping("/ProveedorListar")
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Proveedores");
        model.addAttribute("proveedor", proveedorDao.findAll());

        return "ProveedorListar";
    }

    @GetMapping("/RegistrarProveedor")
    public String crear(Model model) {
        ProveedorJoinContacto usuarioContacto = new ProveedorJoinContacto();

        model.addAttribute("usuarioContacto", usuarioContacto);
        model.addAttribute("button2", "Registrarme");
        return "RegistrarProveedor";
    }

    @PostMapping("/RegistrarProveedor")
    public String guardar(ProveedorJoinContacto proveedorContacto, SessionStatus status) {

        proveedorDao.save(proveedorContacto.getProveedor());
        proveedorContacto.getContactoInfo().setId(proveedorContacto.getProveedor().getId());
        proveedorContacto.getContactoInfo().setProveedorId(proveedorContacto.getProveedor());
        contactoDao.save(proveedorContacto.getContactoInfo());

        System.out.println(proveedorContacto.getContactoInfo().getDepartamento());

        status.setComplete();
        return "redirect:/ProveedorListar";
    }

    @GetMapping("/RegistrarProveedor/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        Proveedor proveedor = null;
        System.out.println("****" + id);
        if (id > 0) {
            proveedor = proveedorDao.findOne(id);
            System.out.println("****" + id);
        } else {
            return "redirect:/ProveedorListar";
        }

        model.addAttribute("titulo", "Editar Proveedor");
        model.addAttribute("proveedor", proveedor);
        model.addAttribute("button", "Guardar Cambios");
        return "RegistrarProveedor";
    }

    @GetMapping("/eliminarProveedor/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        if (id > 0) 
            proveedorDao.delete(id);
            System.out.println("Ingrese al Eliminar Proveedor" + id);
        
        return "redirect:/ProveedorListar";
    }
}
