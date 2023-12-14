package com.viagens.services;

import java.util.List;

import com.viagens.models.Orcamento;

public interface OrcamentoService {
	
	List<Orcamento> getAllOrcamento();
	
	Orcamento getOrcamentoById(Long id);
	
	Orcamento saveOrcanento(Orcamento orcamento);
	
	Orcamento updateOrcamento(Long id, Orcamento atualizarOrcamento);
	
	void deleteOrcamento(Long id);
	
	

}
