package com.miempresa.tecnologiaventas.com.tecnologiaventas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Proveedor;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Entity.Usuario;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao.IProveedorDao;
import com.miempresa.tecnologiaventas.com.tecnologiaventas.MOdels.Dao.IUsuarioDao;

@Controller
@SessionAttributes("login")
public class LoginController {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private IProveedorDao proveedorDao;
    
    // @GetMapping("/")
    // public ModelAndView home() {
    //     ModelAndView modelAndView = new ModelAndView("Login");
    //     return modelAndView;
    // }

    @GetMapping("/Login")
    public String EnviaAtributo(Model model) {
        
        model.addAttribute("usuario", new Usuario());

        return "Login";
    }

    @PostMapping("/Login")
    public String Validar(Usuario usuario) {
        List<Usuario> listUsuarios = usuarioDao.findAll();
        String direccion = "Login";
        List<Proveedor> listProveedor = proveedorDao.findAll();


        System.out.println("Valores de usuario ingresado " + usuario.getEmail() + " -> " + usuario.getPassword());

        for (int i = 0; i < listUsuarios.size(); i++) {
            if (listUsuarios.get(i).getEmail().equals(usuario.getEmail()) && listUsuarios.get(i).getPassword().equals(usuario.getPassword())) {
                System.out.println("Valide Usuairo: " + listUsuarios.get(i).getEmail() + " -> "+listUsuarios.get(i).getPassword());
                if (listUsuarios.get(i).getCodigoRol() == 1) { //Administrador
                    direccion="redirect:Inicio";
                }
                if (listUsuarios.get(i).getCodigoRol() == 2) { //Usuario
                    direccion="Ventas";
                }                
                System.out.println("Valido el Usuario");
            }
        }

        if (direccion.equals("Login")) {
            for (int i = 0; i < listProveedor.size(); i++) { //Proveedor
                if (listProveedor.get(i).getEmail().equals(usuario.getEmail()) && listProveedor.get(i).getPassword().equals(usuario.getPassword())) {
                    direccion="ProductoListar";
                }
            }
        }
        return direccion;
    }
}
