package com.viagens.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Orcamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeCliente;
	private String email;
	private String telefone;
	private int quantidadePessoas;

	 @ManyToOne
	    @JoinColumn(name = "destino_id")
	    private Destino destino;

	public Orcamento() {
	
	}
	
	public Orcamento(Long id, String nomeCliente, String email, String telefone, int quantidadePessoas,
			Destino destino) {
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.email = email;
		this.telefone = telefone;
		this.quantidadePessoas = quantidadePessoas;
		this.destino = destino;
	}

	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getQuantidadePessoas() {
		return quantidadePessoas;
	}

	public void setQuantidadePessoas(int quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}

	
	
	
}
