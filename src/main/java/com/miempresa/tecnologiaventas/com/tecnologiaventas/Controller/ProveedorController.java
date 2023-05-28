package com.miempresa.tecnologiaventas.com.tecnologiaventas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao.InterfaceCRUD;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.ContactoInfo;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Proveedor;

@Controller
@SessionAttributes("proveedor")
public class ProveedorController {
    @Autowired
    private InterfaceCRUD<Proveedor> proveedorDao;

    @Autowired
    private InterfaceCRUD<ContactoInfo> contactoDao;

    @GetMapping("CRUDs/ProveedorListar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Proveedores");
        model.addAttribute("proveedor", contactoDao.findAll());

        return "CRUDs/ProveedorListar";
    }

    @GetMapping("/InicioSesion/ProveedorRegistrar")
    public String crear(Model model) {
        ContactoInfo proveedor = new ContactoInfo();

        model.addAttribute("proveedor", proveedor);
        model.addAttribute("button2", "Registrarme");
        return "CRUDs/ProveedorRegistrar";
    }

    @PostMapping("/CRUDs/ProveedorRegistrar")
    public String guardar(ContactoInfo contactoInfo, SessionStatus status) {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(contactoInfo.getId());
        proveedor.setProveedorNombre(contactoInfo.getProveedor().getProveedorNombre());
        System.out.println("Correo Guardado : " + contactoInfo.getProveedor().getEmail());
        proveedor.setEmail(contactoInfo.getProveedor().getEmail());
        proveedor.setPassword(contactoInfo.getProveedor().getPassword());

        contactoInfo.setProveedor(proveedor);
        proveedorDao.save(proveedor);
        contactoDao.save(contactoInfo);

        status.setComplete();
        return "redirect:/CRUDs/ProveedorListar";
    }

    @GetMapping("/InicioSesion/ProveedorRegistrar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        ContactoInfo proveedor = null;
        System.out.println("****" + id);
        if (id > 0) {
            proveedor = contactoDao.findOne(id);
            System.out.println("****" + id);
        } else {
            return "redirect:/CRUDs/ProveedorListar";
        }

        model.addAttribute("titulo", "Editar Proveedor");
        model.addAttribute("proveedor", proveedor);
        model.addAttribute("button2", "Guardar Cambios");
        return "InicioSesion/ProveedorRegistrar";
    }

    @GetMapping("/CRUDs/eliminarProveedor/{id}")
    public String eliminar(@PathVariable(value = "id") Long id) {
        if (id > 0)
            proveedorDao.delete(id);
        System.out.println("Ingrese al Eliminar Proveedor" + id);

        return "redirect:/CRUDs/ProveedorListar";
    }
}
