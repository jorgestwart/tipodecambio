package com.prueba.modulo.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ParamExchange {
	
	private BigDecimal monto;
	
	private String monedaorigen;
    
    private String monedadestino;

    
    
    
	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
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
    
}
