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
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Usuario;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {
    @Autowired
    private InterfaceCRUD<Usuario> usuarioDao;

    @GetMapping("CRUDs/UsuarioListar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Usuarios");
        model.addAttribute("usuario", usuarioDao.findAll());

        return "CRUDs/UsuarioListar";
    }

    @GetMapping("/InicioSesion/RegistrarUsuario")
    public String crear(Model model) {
        Usuario usuario = new Usuario();

        model.addAttribute("usuario", usuario);
        model.addAttribute("button2", "Registrarme");
        return "InicioSesion/RegistrarUsuario";
    }

    @PostMapping("InicioSesion/RegistrarUsuario")
    public String guardar(Usuario usuario, SessionStatus status) {

        usuarioDao.save(usuario);
        
        status.setComplete();
        return "/InicioSesion/Login";
    }

    //Falta implementar el Modificar con el correo ingresado por X Usuario
    @GetMapping("/InicioSesion/RegistrarUsuario/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        Usuario usuario = null;
        System.out.println("****" + id);
        if (id > 0) {
            usuario = usuarioDao.findOne(id);
            System.out.println("****" + id);
        } else {
            return "redirect:InicioSesion/Login";
        }

        model.addAttribute("titulo", "Editar Usuario");
        model.addAttribute("usuario", usuario);
        model.addAttribute("button", "Guardar Cambios");
        return "InicioSesion/RegistrarUsuario";
    }

    @GetMapping("/CRUDs/eliminarUsuario/{id}")
    public String eliminar(@PathVariable(value = "id") Long id) {
        if (id > 0)
            usuarioDao.delete(id);
        System.out.println("Ingrese al Eliminar Usuario " + id);

        return "redirect:/CRUDs/UsuarioListar";
    }
}
