package com.prueba.modulo.service;

import java.util.List;

import com.prueba.modulo.model.Currency;

public interface CurrencyService {
	
	Currency createCurrency(Currency currency);
	
	Currency updateCurrency(Currency currency);
	
	List<Currency> getAllCurrency();
	
	Currency getCurrencyById(String currencyId);
	
	void deleteCurrency(String id);
	
}
