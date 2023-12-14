package com.viagens.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.viagens.models.Promocao;
import com.viagens.services.PromocaoService;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {
	
	@Autowired
	private PromocaoService promocaoService;
	
	@GetMapping("/lista")
	public String listPromocao(Model model) {
		List<Promocao> promocoes =  promocaoService.geAllPromocao();
		model.addAttribute("promocao", promocoes);
		return "listarPromocao";
	}
	
	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
		Promocao promocoes = new Promocao();
		model.addAttribute("promocao", promocoes);
		return "cadastraPromocao";
	}
	
	@PostMapping("/save")
	public String saveCategoria(@ModelAttribute("promocao") Promocao promocao) {
		 promocaoService.savePromocao(promocao);
		 return "redirect:/promocao/lista";
	}
	
	@GetMapping("/editar/{id}")
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		Promocao promocoes =  promocaoService.getPromocaoById(id);
		model.addAttribute("promocao",promocoes);
		return "editarPromocao";
	}
	
	@PostMapping("/editar/{id}")
	public String updatePromocao(@PathVariable Long id, @ModelAttribute("promocao") Promocao promocao) {
		 promocaoService.uptadePromocao(id, promocao);
		 return "redirect:/promocao/lista";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletePromocao(@PathVariable Long id) {
		promocaoService.deletePromocao(id);
		return "redirect:/promocao/lista";
	}

}
