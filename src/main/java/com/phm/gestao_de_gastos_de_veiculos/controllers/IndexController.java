package com.phm.gestao_de_gastos_de_veiculos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/veiculos";
	}
	
	
	@RequestMapping("/gastos")
	public String gastos() {
		return "gasto/gastos";
	}
	
	@RequestMapping("/salvarGasto")
	public String salvarGasto() {
		return "gasto/salvarGasto";
	}

}
