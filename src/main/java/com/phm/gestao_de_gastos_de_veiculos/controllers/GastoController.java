package com.phm.gestao_de_gastos_de_veiculos.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.phm.gestao_de_gastos_de_veiculos.models.Gasto;
import com.phm.gestao_de_gastos_de_veiculos.models.Veiculo;
import com.phm.gestao_de_gastos_de_veiculos.repositories.GastoRepository;
import com.phm.gestao_de_gastos_de_veiculos.repositories.VeiculoRepository;

import jakarta.validation.Valid;

@Controller
public class GastoController {
	
	@Autowired
	private VeiculoRepository vr;
	
	@Autowired
	private GastoRepository gr;
	
	@RequestMapping(value="/gastos",  method = RequestMethod.GET)
	public ModelAndView gastos() {
		ModelAndView mv = new ModelAndView("gasto/gastos");
		Iterable<Gasto> gastos = gr.findAll();
		mv.addObject("gastos", gastos);
		return mv;
	}
	
	@RequestMapping(value="/gastos/sort/{filtro}",  method = RequestMethod.GET)
	public ModelAndView gastosFiltro(@PathVariable("filtro") String filtro) {
		ModelAndView mv = new ModelAndView("gasto/gastos");
		List<Gasto> gastos = new ArrayList<Gasto>();
		if(filtro.equals("new")) {
			 gastos = ((Collection<Gasto>) gr.findAll()).stream().sorted(Comparator.comparing(Gasto::getData).reversed()).toList();
		}
		else if(filtro.equals("old")) {
			gastos = ((Collection<Gasto>) gr.findAll()).stream().sorted(Comparator.comparing(Gasto::getData)).toList();
		}
		else if(filtro.equals("expensive")) {
			gastos = ((Collection<Gasto>) gr.findAll()).stream().sorted(Comparator.comparing(Gasto::getValor).reversed()).toList();
		}
		else if(filtro.equals("cheap")){
			gastos = ((Collection<Gasto>) gr.findAll()).stream().sorted(Comparator.comparing(Gasto::getValor)).toList();
		}
		mv.addObject("gastos", gastos);
		return mv;
	}
	
	@RequestMapping(value="/gastos/{placa}/sort/{filtro}",  method = RequestMethod.GET)
	public ModelAndView gastosVeiculoFiltro(@PathVariable("placa") String placa, @PathVariable("filtro") String filtro) {
		ModelAndView mv = new ModelAndView("gasto/gastos");
		Iterable<Gasto> gastos = gr.findByVeiculoPlaca(placa);
		if(filtro.equals("new")) {
			 gastos = ((Collection<Gasto>) gastos).stream().sorted(Comparator.comparing(Gasto::getData).reversed()).toList();
		}
		else if(filtro.equals("old")) {
			gastos = ((Collection<Gasto>) gastos).stream().sorted(Comparator.comparing(Gasto::getData)).toList();
		}
		else if(filtro.equals("expensive")) {
			gastos = ((Collection<Gasto>) gastos).stream().sorted(Comparator.comparing(Gasto::getValor).reversed()).toList();
		}
		else if(filtro.equals("cheap")){
			gastos = ((Collection<Gasto>) gastos).stream().sorted(Comparator.comparing(Gasto::getValor)).toList();
		}
		mv.addObject("gastos", gastos);
		return mv;
	}
	
	@RequestMapping(value="/gastos/{placa}",  method = RequestMethod.GET)
	public ModelAndView gastosVeiculo(@PathVariable("placa") String placa) {
		ModelAndView mv = new ModelAndView("gasto/gastos");
		Iterable<Gasto> gastos = gr.findByVeiculoPlaca(placa);
		mv.addObject("gastos", gastos);
		return mv;
	}
	
	@RequestMapping(value="/gastos/id/{id}",  method = RequestMethod.GET)
	public ModelAndView editarGasto(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("gasto/editarGasto");
		Optional<Gasto> gasto = gr.findById(id);
		mv.addObject("gasto", gasto);
		return mv;
	}
	
	@RequestMapping(value = "/gastos/id/{id}", method = RequestMethod.POST)
	public String EditarGastoAcao(@PathVariable("id") long id, @Valid Gasto gasto) {
	    gr.save(gasto);	    
	    return "redirect:/gastos/" + gasto.getVeiculo().getPlaca();
	}
	
	
	@RequestMapping(value="/deletarGasto")
	public String deletarGasto(long id){
		gr.deleteById(id);
		return "redirect:/gastos";
	}
	
	
	@RequestMapping(value="/gastos/salvarGasto/{placa}",  method = RequestMethod.GET)
	public ModelAndView salvarGasto(@PathVariable("placa") String placa) {
		Veiculo veiculo = vr.findByPlaca(placa);
		ModelAndView mv = new ModelAndView("/gasto/salvarGasto");
		mv.addObject("veiculo", veiculo);		
		return mv;
	}
	
	
	
	@RequestMapping(value = "/gastos/salvarGasto/{placa}", method = RequestMethod.POST)
	public String salvarGastoAcao(@Valid Gasto gasto, @PathVariable("placa") String placa, BindingResult result) {
		Veiculo veiculo = vr.findByPlaca(placa);
		gasto.setVeiculo(veiculo);
	    gr.save(gasto);
	    return "redirect:/gastos/" + placa;
	}
	
}
