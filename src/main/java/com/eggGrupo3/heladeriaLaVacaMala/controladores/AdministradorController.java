package com.eggGrupo3.heladeriaLaVacaMala.controladores;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.Helado;
import com.eggGrupo3.heladeriaLaVacaMala.servicios.IHeladoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Controller
@RequestMapping("/home-admin")
public class AdministradorController {

    @Autowired
    private IHeladoService heladoService;

    @GetMapping("")
    public String home(Model model) {
        List<Helado> helados = heladoService.findAll();
        model.addAttribute("helados", helados);
        return "home-admin";
    }

}
