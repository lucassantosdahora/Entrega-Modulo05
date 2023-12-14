package com.viagens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viagens.models.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {

}
