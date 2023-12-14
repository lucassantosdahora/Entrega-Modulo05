package com.viagens.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PagesController {


    @GetMapping("/index")
    public String index() {
        return "index";
    }
	
	@GetMapping("/destinos")
	public String destinos() {
		return "destinos";
	}
	@GetMapping("/contatos")
	public String contatos() {
		return "contatos";
	}
	@GetMapping("/promocao")
	public String promocao() {
		return "promocao";
	}
	@GetMapping("/adm")
	public String adm() {
		return "adm";
	}
}
