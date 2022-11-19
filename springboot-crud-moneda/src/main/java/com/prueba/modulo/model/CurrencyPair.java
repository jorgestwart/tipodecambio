package com.prueba.modulo.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "currencyPair")
public class CurrencyPair extends AbstractEntity {
	
	
	public CurrencyPair(String id) {
		super(id);
	}
	
	public CurrencyPair() {
		super();
	}
	
	
	@Size(max = 50)
	@NotNull
	private String descriptionCurrencyPair;
	
	@Size(max = 7)
	@NotNull
	private String abbreviationCurrencyPair;
	
	@Size(max = 3)
	@NotNull
	private String typeOperationCurrencyPair;
	
	@Size(max = 255)
	@NotNull
	private String currencyPairOriId;
	
	@Size(max = 255)
	@NotNull
	private String currencyPairDesId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currencyOri_id")
	private Currency currencyOri;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currencyDes_id")
	private Currency currencyDes;
	
	
	@OneToMany(mappedBy = "currencyPair")
	private List<ExchangeRate> exchangeRates;


	public String getDescriptionCurrencyPair() {
		return descriptionCurrencyPair;
	}

	public void setDescriptionCurrencyPair(String descriptionCurrencyPair) {
		this.descriptionCurrencyPair = descriptionCurrencyPair;
	}

	public String getAbbreviationCurrencyPair() {
		return abbreviationCurrencyPair;
	}

	public void setAbbreviationCurrencyPair(String abbreviationCurrencyPair) {
		this.abbreviationCurrencyPair = abbreviationCurrencyPair;
	}

	public String getTypeOperationCurrencyPair() {
		return typeOperationCurrencyPair;
	}

	public void setTypeOperationCurrencyPair(String typeOperationCurrencyPair) {
		this.typeOperationCurrencyPair = typeOperationCurrencyPair;
	}

	public Currency getCurrencyOri() {
		return currencyOri;
	}

	public void setCurrencyOri(Currency currencyOri) {
		this.currencyOri = currencyOri;
	}

	public Currency getCurrencyDes() {
		return currencyDes;
	}

	public void setCurrencyDes(Currency currencyDes) {
		this.currencyDes = currencyDes;
	}

	public List<ExchangeRate> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(List<ExchangeRate> exchangeRates) {
		this.exchangeRates = exchangeRates;
	}

	public String getCurrencyPairOriId() {
		return currencyPairOriId;
	}

	public void setCurrencyPairOriId(String currencyPairOriId) {
		this.currencyPairOriId = currencyPairOriId;
	}

	public String getCurrencyPairDesId() {
		return currencyPairDesId;
	}

	public void setCurrencyPairDesId(String currencyPairDesId) {
		this.currencyPairDesId = currencyPairDesId;
	}
	
}
