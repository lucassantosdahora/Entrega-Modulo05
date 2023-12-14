package com.viagens.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeDestino;

	@Column(columnDefinition = "TEXT")
	private String descricao;
	private String localizacao;


    @ManyToOne
    private Orcamento orcamento;

	 @ManyToOne(optional = true)
	 @JoinColumn(name = "promocao_id", nullable = true)
	 private Promocao promocao;
	 
	public Destino() {

	}

	
	public Destino(Long id, String nomeDestino, String descricao, String localizacao, Orcamento orcamento,
			Promocao promocao) {
		this.id = id;
		this.nomeDestino = nomeDestino;
		this.descricao = descricao;
		this.localizacao = localizacao;
		this.orcamento = orcamento;
		this.promocao = promocao;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDestino() {
		return nomeDestino;
	}

	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}


	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}


	public Promocao getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}
	
	

}
