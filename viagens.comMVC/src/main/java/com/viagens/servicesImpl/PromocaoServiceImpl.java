package com.viagens.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viagens.models.Promocao;
import com.viagens.repositories.PromocaoRepository;
import com.viagens.services.PromocaoService;

@Service
public class PromocaoServiceImpl implements PromocaoService {
	
	@Autowired
	private PromocaoRepository promocaoRepository;

	@Override
	public List<Promocao> geAllPromocao() {
		
		return promocaoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Promocao getPromocaoById(Long id) {
		
		return promocaoRepository.findById(id).orElse(null);
	}

	@Override
	public Promocao savePromocao(Promocao promocao) {
		
		return promocaoRepository.save(promocao);
	}

	@Override
	public Promocao uptadePromocao(Long id, Promocao atualizarPromocao) {
		Promocao promocaoExistente = promocaoRepository.findById(id).orElse(null);
		if (promocaoExistente != null) {
			promocaoExistente.setNomePromocao(atualizarPromocao.getNomePromocao());
			promocaoExistente.setDescricao(atualizarPromocao.getDescricao());
			promocaoExistente.setValidade(atualizarPromocao.getValidade());
		}else {
			throw new RuntimeException("Promoção com o ID " + id + " não encontrada.");
		}
		return promocaoRepository.save(promocaoExistente);
	}

	@Override
	public void deletePromocao(Long id) {
		 promocaoRepository.deleteById(id);
		
	}

}
