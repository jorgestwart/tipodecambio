package com.prueba.modulo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.modulo.exception.ResourceNotFoundException;
import com.prueba.modulo.model.Currency;
import com.prueba.modulo.repository.CurrencyRepository;

@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Override
	public Currency createCurrency(Currency currency) {
		return currencyRepository.save(currency);
	}

	@Override
	public Currency updateCurrency(Currency currency) {
		Optional<Currency> currencyDb = this.currencyRepository.findById(currency.getId());
		
		if(currencyDb.isPresent()) {
			Currency currencyUpdate = currencyDb.get();
			currencyUpdate.setId(currency.getId());
			currencyUpdate.setDescriptionCurrency(currency.getDescriptionCurrency());
			currencyUpdate.setAbbreviationCurrency(currency.getAbbreviationCurrency());
			currencyUpdate.setSymbolCurrency(currency.getSymbolCurrency());
			currencyUpdate.setCountryCurrency(currency.getCountryCurrency());
			currencyRepository.save(currencyUpdate);
			return currencyUpdate;
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + currency.getId());
		}		
	}

	@Override
	public List<Currency> getAllCurrency() {
		return this.currencyRepository.findAll();
	}

	@Override
	public Currency getCurrencyById(String currencyId) {
		Optional<Currency> currencyDb = this.currencyRepository.findById(currencyId);		
		if(currencyDb.isPresent()) {
			return currencyDb.get();
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + currencyId);
		}		
	}

	@Override
	public void deleteCurrency(String currencyId) {
		Optional<Currency> currencyDb = this.currencyRepository.findById(currencyId);		
		if(currencyDb.isPresent()) {
			this.currencyRepository.delete(currencyDb.get());
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + currencyId);
		}
		
	}

}
