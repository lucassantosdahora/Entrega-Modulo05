package com.viagens.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Promocao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomePromocao;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date validade;


	@OneToMany(mappedBy = "promocao")
	private List<Destino> destinos = new ArrayList<>();

	public Promocao() {
		
	}

	

	public Promocao(Long id, String nomePromocao, String descricao, Date validade, List<Destino> destinos) {
		this.id = id;
		this.nomePromocao = nomePromocao;
		this.descricao = descricao;
		this.validade = validade;
		this.destinos = destinos;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePromocao() {
		return nomePromocao;
	}

	public void setNomePromocao(String nomePromocao) {
		this.nomePromocao = nomePromocao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	

}
