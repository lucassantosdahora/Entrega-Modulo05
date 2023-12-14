package com.viagens.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viagens.models.Destino;
import com.viagens.repositories.DestinoRepository;
import com.viagens.services.DestinoService;



@Service
public class DestinoServiceImpl  implements DestinoService{
	
	@Autowired
	private DestinoRepository destinoRepository;

	@Override
	public List<Destino> geAllDestino() {
		return destinoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Destino getDestinoById(Long id) {
	
		return destinoRepository.findById(id).orElse(null);
	}

	@Override
	public Destino saveDestino(Destino destino) {
		
		return  destinoRepository.save(destino);
	}
    
	@Transactional
	@Override
	public Destino updateDestino(Long id, Destino atualizarDestino) {
		Destino destinoExistente = destinoRepository.findById(id).orElse(null);
		if (destinoExistente != null) {
			destinoExistente.setNomeDestino(atualizarDestino.getNomeDestino());
			destinoExistente.setDescricao(atualizarDestino.getDescricao());
			destinoExistente.setLocalizacao(atualizarDestino.getLocalizacao());
			destinoExistente.setPromocao(atualizarDestino.getPromocao());
		}else {
			throw new RuntimeException("Destino com o ID " + id + " não encontrada.");
		}
		return destinoRepository.save(destinoExistente);
	}

	@Override
	public void deleteDestino(Long id) {
		 destinoRepository.deleteById(id);
		
	}

}
