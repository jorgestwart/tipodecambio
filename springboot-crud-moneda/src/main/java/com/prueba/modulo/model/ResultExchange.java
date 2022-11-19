package com.prueba.modulo.model;

import java.math.BigDecimal;

public class ResultExchange {

	private BigDecimal monto;
    
	private BigDecimal montocontipocambio;
    
    private String monedaorigen;
    
    private String monedadestino; 
    
    private BigDecimal tipodecambio;


    
	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public BigDecimal getMontocontipocambio() {
		return montocontipocambio;
	}

	public void setMontocontipocambio(BigDecimal montocontipocambio) {
		this.montocontipocambio = montocontipocambio;
	}

	public String getMonedaorigen() {
		return monedaorigen;
	}

	public void setMonedaorigen(String monedaorigen) {
		this.monedaorigen = monedaorigen;
	}

	public String getMonedadestino() {
		return monedadestino;
	}

	public void setMonedadestino(String monedadestino) {
		this.monedadestino = monedadestino;
	}

	public BigDecimal getTipodecambio() {
		return tipodecambio;
	}

	public void setTipodecambio(BigDecimal tipodecambio) {
		this.tipodecambio = tipodecambio;
	}
	
}
