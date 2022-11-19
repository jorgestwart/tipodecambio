package com.prueba.modulo.service;

import java.util.List;

import com.prueba.modulo.model.ExchangeRate;
import com.prueba.modulo.model.ParamExchange;
import com.prueba.modulo.model.ResultExchange;

public interface ExchangeRateService {

	ExchangeRate createExchangeRate(ExchangeRate exchangeRate);
	
	ExchangeRate updateExchangeRate(ExchangeRate exchangeRate);
	
	List<ExchangeRate> getAllExchangeRate();
	
	ExchangeRate getExchangeRateById(String exchangeRateId);
	
	void deleteExchangeRate(String id);

	ResultExchange calcExchangeRate(ParamExchange paramExchange);
		
}
