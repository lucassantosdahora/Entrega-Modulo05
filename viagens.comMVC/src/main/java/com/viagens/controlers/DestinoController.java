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
import com.viagens.models.Promocao;
import com.viagens.services.DestinoService;
import com.viagens.services.PromocaoService;

@Controller
@RequestMapping("/destino")
public class DestinoController {

	@Autowired
	private DestinoService destinoService;

	@Autowired
	private PromocaoService promocaoService;

	@GetMapping("/lista")
	public String listDestino(Model model) {
		List<Destino> destinos = destinoService.geAllDestino();
		model.addAttribute("destino", destinos);
		return "ListarDestino";
	}

	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
		Destino destinos = new Destino();
		List<Promocao> promocoes = promocaoService.geAllPromocao();
		model.addAttribute("destino", destinos);
		model.addAttribute("promocao", promocoes);
		return "cadastraDestino";
	}

	@PostMapping("/save")
	public String saveDestino(@ModelAttribute("destino") @Validated Destino destino, BindingResult result) {
	    if (destino.getPromocao() != null && destino.getPromocao().getId() == null) {
	        destino.setPromocao(null); // Define o campo promocao como nulo se o id for nulo
	    }
	    
	    destinoService.saveDestino(destino);

	    return "redirect:/destino/lista";
	}


	@GetMapping("/editar/{id}")
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		Destino destinos = destinoService.getDestinoById(id);
		List<Promocao> promocoes = promocaoService.geAllPromocao();
		model.addAttribute("destino", destinos);
		model.addAttribute("promocao", promocoes);
		return "editarDestino";
	}

	@PostMapping("/editar/{id}")
	public String updateDestino(@PathVariable Long id, @ModelAttribute("destino") Destino destino) {
		if (destino.getPromocao() != null && destino.getPromocao().getId() == null) {
		        destino.setPromocao(null); // Define o campo promocao como nulo se o id for nulo
		    }
		destinoService.updateDestino(id, destino);
		
		return "redirect:/destino/lista";
	}
	
	@GetMapping("/deletar/{id}")
	public String deleteDestino(@PathVariable Long id) {
		destinoService.deleteDestino(id);
		return "redirect:/destino/lista";
	}

}