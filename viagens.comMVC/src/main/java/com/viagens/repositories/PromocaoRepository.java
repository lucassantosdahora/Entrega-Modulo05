package com.viagens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viagens.models.Promocao;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao,Long> {

}
