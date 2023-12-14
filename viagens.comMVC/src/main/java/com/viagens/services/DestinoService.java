package com.viagens.services;

import java.util.List;

import com.viagens.models.Destino;

public interface DestinoService {
	
	List<Destino> geAllDestino();
	
	Destino getDestinoById(Long id);
	
	Destino saveDestino (Destino destino);
	
	Destino updateDestino(Long id, Destino atualizarDestino);
	
	void deleteDestino(Long id);

}
