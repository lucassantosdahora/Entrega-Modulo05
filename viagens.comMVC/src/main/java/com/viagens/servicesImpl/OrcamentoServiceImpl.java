package com.viagens.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viagens.models.Orcamento;
import com.viagens.repositories.OrcamentoRepository;
import com.viagens.services.OrcamentoService;

@Service
public class OrcamentoServiceImpl implements OrcamentoService{
	
	@Autowired
	private OrcamentoRepository orcamentoRepository;

	@Override
	public List<Orcamento> getAllOrcamento() {
		
		return  orcamentoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Orcamento getOrcamentoById(Long id) {
	
		return  orcamentoRepository.findById(id).orElse(null);
	}

	@Override
	public Orcamento saveOrcanento(Orcamento orcamento) {
		
		return orcamentoRepository.save(orcamento);
	}

	@Override
	public Orcamento updateOrcamento(Long id, Orcamento atualizarOrcamento) {
		Orcamento orcamentoExistente = orcamentoRepository.findById(id).orElse(null);
		if (orcamentoExistente != null) {
			orcamentoExistente.setNomeCliente(atualizarOrcamento.getNomeCliente());
			orcamentoExistente.setEmail(atualizarOrcamento.getEmail());
			orcamentoExistente.setTelefone(atualizarOrcamento.getTelefone());
			orcamentoExistente.setDestino(atualizarOrcamento.getDestino());
			orcamentoExistente.setQuantidadePessoas(atualizarOrcamento.getQuantidadePessoas());
		
		}else {
			throw new RuntimeException("Orçamento com o ID " + id + " não encontrada.");
		}
		return  orcamentoRepository.save(orcamentoExistente);
		
	}

	@Override
	public void deleteOrcamento(Long id) {
		 orcamentoRepository.deleteById(id);
		
	}

}
