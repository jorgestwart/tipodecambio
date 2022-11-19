package com.prueba.modulo.service;

import java.util.List;

import com.prueba.modulo.model.CurrencyPair;

public interface CurrencyPairService {

	CurrencyPair createCurrencyPair(CurrencyPair currencyPair);
	
	CurrencyPair updateCurrencyPair(CurrencyPair currencyPair);
	
	List<CurrencyPair> getAllCurrencyPair();
	
	CurrencyPair getCurrencyPairById(String CurrencyPairId);
	
	void deleteCurrencyPair(String Id);
	
}
