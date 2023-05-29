package com.miempresa.tecnologiaventas.com.tecnologiaventas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao.InterfaceCRUD;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Administrador;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Proveedor;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Usuario;

@Controller
@SessionAttributes("login")
public class LoginController {

    @Autowired
    private InterfaceCRUD<Usuario> usuarioDao;

    @Autowired
    private InterfaceCRUD<Administrador> administradorDao;

    @Autowired
    private InterfaceCRUD<Proveedor> proveedorDao;

    @GetMapping("/")
    public String EnviaAtributo(Model model) {
        model.addAttribute("usuario", new Usuario());

        return "InicioSesion/Login";
    }

    @PostMapping("Login")
    public String Validar(Usuario usuario) {
        String direccion = "InicioSesion/Login";

        List<Usuario> listUsuarios = usuarioDao.findAll();
        List<Proveedor> listProveedor = proveedorDao.findAll();
        List<Administrador> listAdmin = administradorDao.findAll();

        System.out.println("Valores de usuario ingresado " + usuario.getEmail() + " -> " + usuario.getPassword());

        for (int i = 0; i < listUsuarios.size(); i++) { //Usuarios
            if (listUsuarios.get(i).getEmail().equals(usuario.getEmail())
                    && listUsuarios.get(i).getPassword().equals(usuario.getPassword())) {
                direccion = "redirect:CRUDs/VentaForm";
                System.out.println("Valido el Usuario");
                
                return direccion;
            }
        }

        if (direccion.equals("InicioSesion/Login")) {
            for (int j = 0; j < listProveedor.size(); j++) { // Proveedor
                if (listProveedor.get(j).getEmail().equals(usuario.getEmail())
                        && listProveedor.get(j).getPassword().equals(usuario.getPassword())) {
                    direccion = "redirect:CRUDs/ProductoListar";
                    System.out.println("Valido el Proveedor");
                
                    return direccion;
                }
            }
        }

        if (direccion.equals("InicioSesion/Login")) {
            for (int k = 0; k < listAdmin.size(); k++) { // Administradores
                if (listAdmin.get(k).getEmail().equals(usuario.getEmail())
                        && listAdmin.get(k).getPassword().equals(usuario.getPassword())) {
                    direccion = "redirect:General/Inicio";
                    System.out.println("Valido el Administrador");
                
                    return direccion;
                }
            }
        }
        return direccion;
    }
}
