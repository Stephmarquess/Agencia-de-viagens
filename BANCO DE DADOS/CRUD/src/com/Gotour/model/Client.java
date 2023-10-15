package com.Gotour.model;

public class Client {
	
	private int idCliente; 
	private String nomeCliente;
	private String telefone; 
	private String email;
	private String cpf; 
	private String endereco;
	

	public Client() {
		super();

	}


	public Client(String nomeCliente, String telefone, String email, String cpf, String endereco) {
		super();
		this.nomeCliente = nomeCliente;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.endereco = endereco;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
}
