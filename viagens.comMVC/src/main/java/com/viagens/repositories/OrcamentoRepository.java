package com.viagens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viagens.models.Orcamento;

@Repository
public interface OrcamentoRepository  extends JpaRepository<Orcamento, Long>{

}
