package com.eggGrupo3.heladeriaLaVacaMala.controladores;

import groovyjarjarpicocli.CommandLine.Model;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("")
    public String index(Model model, HttpServletRequest request) {
        if(request.isUserInRole("ROLE_USUARIO_REGISTRADO")){
            return "inicio";
        }
        return "index";
    }

 
}
