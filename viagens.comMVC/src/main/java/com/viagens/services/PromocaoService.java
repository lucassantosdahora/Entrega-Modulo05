package com.viagens.services;

import java.util.List;

import com.viagens.models.Promocao;

public interface PromocaoService {
	
	List<Promocao> geAllPromocao();
	
	Promocao getPromocaoById(Long id);
	
	Promocao savePromocao(Promocao promocao);
	
	Promocao uptadePromocao(Long id, Promocao atualizarPromocao);
	
	void deletePromocao(Long id);
	

}
