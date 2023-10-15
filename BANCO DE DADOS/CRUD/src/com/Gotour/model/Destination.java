package com.Gotour.model;


public class Destination { 
	
	private int idDestino;
	private String descricaoDestino;
	private String nomeDestino; 	

	public Destination() {
		super();
	}


	public Destination(String descricaoDestino, String nomeDestino ) {
		super();
		this.descricaoDestino = descricaoDestino; 
		this.nomeDestino = nomeDestino;
	}


	public int getIdDestino() {
		return idDestino;
	}


	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public String getDescricaoDestino() {
		return descricaoDestino;
	}
	
	public void setDescricaoDestino(String descricaoDestino) {
		this.descricaoDestino = descricaoDestino;
	}
	
	public String getNomeDestino() {
		return nomeDestino;
	}


	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}

}
