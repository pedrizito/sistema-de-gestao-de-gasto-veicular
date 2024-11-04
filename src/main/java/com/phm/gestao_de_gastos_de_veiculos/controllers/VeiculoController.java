package com.phm.gestao_de_gastos_de_veiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phm.gestao_de_gastos_de_veiculos.models.Veiculo;
import com.phm.gestao_de_gastos_de_veiculos.repositories.VeiculoRepository;

import jakarta.validation.Valid;

@Controller
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository vr;
	
	@RequestMapping(value="/veiculos",  method = RequestMethod.GET)
	public ModelAndView veiculos() {
		ModelAndView mv = new ModelAndView("veiculo/veiculos");
		Iterable<Veiculo> veiculos = vr.findAll();
		mv.addObject("veiculos", veiculos);
		return mv;
	}
	
	@RequestMapping(value="/veiculos/{placa}", method=RequestMethod.GET)
	public ModelAndView editarVeiculo(@PathVariable("placa") String placa){
		Veiculo veiculo = vr.findByPlaca(placa);
		ModelAndView mv = new ModelAndView("/veiculo/editarVeiculo");
		mv.addObject("veiculo", veiculo);		
		return mv;
	}
	
	@RequestMapping(value="/deletarVeiculo")
	public String deletarVeiculo(String placa, RedirectAttributes attributes){
		Veiculo veiculo = vr.findByPlaca(placa);		
		try {
			vr.delete(veiculo);
		}
		catch(DataIntegrityViolationException e) {
			attributes.addFlashAttribute("mensagem", "Você não pode deletar um veículo com gastos registrados!");
			return "redirect:/veiculos/" + placa;
		}
		return "redirect:/veiculos";
	}
	
	
	@RequestMapping(value="/veiculos/{placa}", method=RequestMethod.POST)
	public String editarVeiculoAcao(@Valid Veiculo veiculo, BindingResult result){
	    vr.save(veiculo);
	    return "redirect:/veiculos";
	}
	
	@RequestMapping(value="/salvarVeiculo",  method = RequestMethod.GET)
	public String salvarVeiculo() {
		return "veiculo/salvarVeiculo";
	}
	
	
	@RequestMapping(value = "/salvarVeiculo", method = RequestMethod.POST)
	public String salvarVeiculo(@Valid Veiculo veiculo, BindingResult result) {
		if (veiculo.getPlaca() == null || veiculo.getPlaca().isEmpty()) {
            return "veiculo/salvarVeiculo";
        }
	    vr.save(veiculo);
	    return "redirect:/veiculos";
	}
	
}
