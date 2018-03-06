package com.example.catalog.dto;

public class Catalog {
	
	private String clave;
	private String valor;
	
	
	
	public Catalog(String clave, String valor) {
		super();
		this.clave = clave;
		this.valor = valor;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return valor;
	}
	

}
