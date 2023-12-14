package com.viagens.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.viagens.models.Destino;
import com.viagens.models.Orcamento;
import com.viagens.services.DestinoService;
import com.viagens.services.OrcamentoService;

@Controller
@RequestMapping("/orcamento")
public class OrcamentoController {
	
	@Autowired
	private OrcamentoService orcamentoService;
	
	@Autowired
	private DestinoService destinoService;
	
	@GetMapping("/lista")
	public String listOrcamento(Model model) {
		List<Orcamento> orcamentos = orcamentoService.getAllOrcamento();
		model.addAttribute("orcamento",orcamentos);
		return "listarOrcamento";
	}
	
	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
		Orcamento orcamentos = new Orcamento();
		List<Destino> Destinos = destinoService.geAllDestino();
		model.addAttribute("destino",Destinos);
		model.addAttribute("orcamento",orcamentos);
		return "Orcamento";
	}
	
	@PostMapping("/save")
	 public String saveOrcamento(@ModelAttribute("orcamento") @Validated Orcamento orcamento, BindingResult result) {
		 orcamentoService.saveOrcanento(orcamento);
		 return "redirect:/orcamento/lista";
	 }
	
	  @GetMapping("/editar/{id}")
	  public String showFormForUpdate(@PathVariable Long id, Model model) {
		  Orcamento orcamentos =  orcamentoService.getOrcamentoById(id);
		  List<Destino> Destinos = destinoService.geAllDestino();
			model.addAttribute("destino",Destinos);
			model.addAttribute("orcamento",orcamentos);
			return "editarOrcamento";
		  
	  }
	  
	 @PostMapping("/editar/{id}")
	  public String updateOrcamento(@PathVariable Long id, @ModelAttribute("orcamento") Orcamento orcamento) {
		  orcamentoService.updateOrcamento(id, orcamento);
		  return "redirect:/orcamento/lista";
	  }
	  
	  @GetMapping("/deletar/{id}")
	  public String deleteOrcamento(@PathVariable Long id) {
		  orcamentoService.deleteOrcamento(id);
		  return "redirect:/orcamento/lista";
	  }

}
