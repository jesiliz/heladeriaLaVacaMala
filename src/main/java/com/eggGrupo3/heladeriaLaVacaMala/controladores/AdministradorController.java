package com.eggGrupo3.heladeriaLaVacaMala.controladores;

import com.eggGrupo3.heladeriaLaVacaMala.entidades.Helado;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import com.eggGrupo3.heladeriaLaVacaMala.servicios.HeladoService;



@Controller
@RequestMapping("/home-admin")
public class AdministradorController {

	@Autowired
	private HeladoService heladoService;

	@GetMapping("")
	public String home(Model model) {

		List<Helado> helados = heladoService.findAll();
		model.addAttribute("helados", helados);

		return "home-admin";
	}
	
}
