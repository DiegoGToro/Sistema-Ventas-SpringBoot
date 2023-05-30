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
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Administrador;

@Controller
@SessionAttributes("administrador")
public class AdministradorController {
    @Autowired
    private InterfaceCRUD<Administrador> adminDao;

    @GetMapping("CRUDs/AdminListar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Administradores");
        model.addAttribute("administrador", adminDao.findAll());

        return "CRUDs/AdminListar";
    }

    @GetMapping("/CRUDs/AdminForm")
    public String crear(Model model) {
        Administrador admin = new Administrador();

        model.addAttribute("administrador", admin);
        model.addAttribute("button", "Registrar Administrador");
        return "CRUDs/AdminForm";
    }

    @PostMapping("/CRUDs/AdminForm")
    public String guardar(Administrador admin, SessionStatus status) {
        adminDao.save(admin);
        status.setComplete();

        return "redirect:/CRUDs/AdminListar";
    }

    @GetMapping("/CRUDs/AdminForm/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        Administrador admin = null;
        System.out.println("****" + id);
        if (id > 0) {
            admin = adminDao.findOne(id);
            System.out.println("****" + id);
        } else {
            return "redirect:/CRUDs/AdminListar";
        }

        model.addAttribute("titulo", "Editar Administrador");
        model.addAttribute("administrador", admin);
        model.addAttribute("button", "Guardar Cambios");
        return "CRUDs/AdminForm";
    }

    @GetMapping("/CRUDs/eliminarAdministrador/{id}")
    public String eliminar(@PathVariable(value = "id") Long id) {
        if (id > 0)
            adminDao.delete(id);
        System.out.println("Ingrese al Eliminar Administrador " + id);

        return "redirect:/CRUDs/AdminListar";
    }
}
