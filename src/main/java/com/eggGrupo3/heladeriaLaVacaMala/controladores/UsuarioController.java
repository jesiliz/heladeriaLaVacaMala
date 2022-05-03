package com.eggGrupo3.heladeriaLaVacaMala.controladores;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.Usuario;
import com.eggGrupo3.heladeriaLaVacaMala.servicios.ErrorService;
import com.eggGrupo3.heladeriaLaVacaMala.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error,@RequestParam(required = false) String logout, ModelMap modelo) {
        if(error != null){
            modelo.put("error", "Usuario y/o contraseña incorrectos.");
        }
        if(logout != null){
            modelo.put("logout", "Se ha deslogueado correctamente.");
        }
        return "/login";
    }

    @GetMapping("/registro")
    public String registro(Model modelo) {
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "registro";
    }

    @PreAuthorize("hasAnyRole('ROLE_USUARIO_REGISTRADO')")
    @GetMapping("/inicio")
    public String inicio() {     
        return "inicio.html";
    }

    @PostMapping("/registro")
    public String registrar(ModelMap modelo, @ModelAttribute("usuario") Usuario usuario) {
        try
        {
            usuarioService.registro(usuario);
        } catch (ErrorService e)
        {
            modelo.put("error", e.getMessage());
            modelo.put("nombre", usuario.getNombre());
            modelo.put("email", usuario.getEmail());
            modelo.put("email", usuarioService.emailExist(usuario.getEmail()));
            modelo.put("domicilio", usuario.getDomicilio());
            modelo.put("telefono", usuario.getTelefono());
            modelo.put("contrasenia", usuario.getContrasenia());
            return "registro";
        }

        modelo.put("registroCompleto", "Usuario registrado exitosamente");
        return "login";
    }
}
