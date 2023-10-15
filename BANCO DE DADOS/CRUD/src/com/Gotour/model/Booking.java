package com.Gotour.model;

//import java.util.Date;

public class Booking {

	private int idReserva;	
	private String descricaoReserva; 
	private double valor;
	private String tipoPagamento;
	private String dataIda;
	private String dataVolta;
	private Client Client;
	private Destination Destination;
		
	
		
	public int getIdReserva() {
		return idReserva;
	}



	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}



	public String getDescricaoReserva() {
		return descricaoReserva;
	}



	public void setDescricaoReserva(String descricaoReserva) {
		this.descricaoReserva = descricaoReserva;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public String getDataIda() {
		return dataIda;
	}



	public void setDataIda(String dataIda) {
		this.dataIda = dataIda;
	}
	
	


	public String getDataVolta() {
		return dataVolta;
	}



	public void setDataVolta(String dataVolta) {
		this.dataVolta = dataVolta;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		this.Client = client;
	}
	
	public Destination getDestination() {
		return Destination;
	}

	public void setDestination(Destination destination) {
		this.Destination = destination;
	}


	public String getTipoPagamento() {
		return tipoPagamento;
	}



	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}


	@Override
	public String toString() {
		return "Booking [idReserva=" + idReserva + ", descricaoReserva=" + descricaoReserva + ", valor=" + valor
				+ ", dataIda=" + dataIda + ", dataVolta=" + dataIda + ", client=" + Client + ", tipoPagamento="
				+ tipoPagamento + "]";
	}
	
	
	
}
