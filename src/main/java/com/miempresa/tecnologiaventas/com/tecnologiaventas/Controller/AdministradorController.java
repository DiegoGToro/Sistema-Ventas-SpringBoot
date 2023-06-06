package com.miempresa.tecnologiaventas.com.tecnologiaventas.Controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao.AdministradorDaoImp;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Usuario;

@Controller
@SessionAttributes("administrador")
public class AdministradorController {

    private final Logger log = LoggerFactory.getLogger(AdministradorController.class);
    @Autowired
    private AdministradorDaoImp adminDao;

    @GetMapping("CRUDs/AdminListar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Administradores");
        model.addAttribute("administrador", adminDao.findAll());

        return "CRUDs/AdminListar";
    }

    @GetMapping("/CRUDs/AdminForm")
    public String crear(Model model) {
        Usuario admin = new Usuario();

        model.addAttribute("titulo", "Fomulario de Administrador");
        model.addAttribute("administrador", admin);
        model.addAttribute("button", "Registrar Administrador");
        return "CRUDs/AdminForm";
    }

    @PostMapping("/CRUDs/AdminForm")
    public String guardar(Usuario admin, SessionStatus status) {
        admin.setRolUsuario((byte)2); //seteando el rol de Administrador
        adminDao.save(admin);
        status.setComplete();
        log.info("Este es el Producto {}" + admin);

        return "redirect:/CRUDs/AdminListar";
    }

    @GetMapping("/CRUDs/AdminForm/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        Usuario admin = null;
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
