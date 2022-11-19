package com.prueba.modulo.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "exchangeRate")
public class ExchangeRate extends AbstractEntity {
	
	
	public ExchangeRate(String id) {
		super(id);
	}
	
	public ExchangeRate() {
		super();
	}
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dateExchangeRate;
	
	@Digits(integer=12, fraction=3)
	@NotNull
	private BigDecimal amountExchangeRate;
	
	@Size(max = 255)
	@NotNull
	private String currencyPairIdem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currencyPair_id")
	private CurrencyPair currencyPair;

	
	
	
	
	public Calendar getDateExchangeRate() {
		return dateExchangeRate;
	}

	public void setDateExchangeRate(Calendar dateExchangeRate) {
		this.dateExchangeRate = dateExchangeRate;
	}

	public BigDecimal getAmountExchangeRate() {
		return amountExchangeRate;
	}

	public void setAmountExchangeRate(BigDecimal amountExchangeRate) {
		this.amountExchangeRate = amountExchangeRate;
	}

	public CurrencyPair getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(CurrencyPair currencyPair) {
		this.currencyPair = currencyPair;
	}

	public String getCurrencyPairIdem() {
		return currencyPairIdem;
	}

	public void setCurrencyPairIdem(String currencyPairIdem) {
		this.currencyPairIdem = currencyPairIdem;
	}
	
}
