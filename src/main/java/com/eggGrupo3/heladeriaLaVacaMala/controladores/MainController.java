package com.eggGrupo3.heladeriaLaVacaMala.controladores;

import groovyjarjarpicocli.CommandLine.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    
    @GetMapping({"/home-admin"})
    public String admin(Model model) {
        return "home-admin";
    }
}
