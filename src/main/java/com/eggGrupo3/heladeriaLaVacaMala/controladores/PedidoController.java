package com.eggGrupo3.heladeriaLaVacaMala.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    
    // localhost:8080/pedido/form
    @GetMapping("/form")
    public String form(){
        return "pedido-form";
    }
}
