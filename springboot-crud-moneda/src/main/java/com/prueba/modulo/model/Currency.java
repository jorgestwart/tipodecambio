package com.prueba.modulo.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "currency")
public class Currency extends AbstractEntity {
	
	
	public Currency(String id) {
		super(id);
	}
	
	public Currency() {
		super();
	}
	
	@Size(max = 50)
	@NotNull
	private String descriptionCurrency;
	
	@Size(max = 3)
	@NotNull
	private String abbreviationCurrency;
	
	@Size(max = 5)
	@NotNull
	private String symbolCurrency;
	
	@Size(max = 50)
	@NotNull
	private String countryCurrency;

	@OneToMany(mappedBy = "currencyOri")
	private List<CurrencyPair> currencyPairOris;

	
	@OneToMany(mappedBy = "currencyDes")
	private List<CurrencyPair> CurrencyPairDess;


	public String getDescriptionCurrency() {
		return descriptionCurrency;
	}

	public void setDescriptionCurrency(String descriptionCurrency) {
		this.descriptionCurrency = descriptionCurrency;
	}

	public String getAbbreviationCurrency() {
		return abbreviationCurrency;
	}

	public void setAbbreviationCurrency(String abbreviationCurrency) {
		this.abbreviationCurrency = abbreviationCurrency;
	}

	public String getSymbolCurrency() {
		return symbolCurrency;
	}

	public void setSymbolCurrency(String symbolCurrency) {
		this.symbolCurrency = symbolCurrency;
	}

	public String getCountryCurrency() {
		return countryCurrency;
	}

	public void setCountryCurrency(String countryCurrency) {
		this.countryCurrency = countryCurrency;
	}

	public List<CurrencyPair> getCurrencyPairOris() {
		return currencyPairOris;
	}

	public void setCurrencyPairOris(List<CurrencyPair> currencyPairOris) {
		this.currencyPairOris = currencyPairOris;
	}

	public List<CurrencyPair> getCurrencyPairDess() {
		return CurrencyPairDess;
	}

	public void setCurrencyPairDess(List<CurrencyPair> currencyPairDess) {
		CurrencyPairDess = currencyPairDess;
	}	
	

	
	
}
