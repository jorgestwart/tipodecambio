package com.prueba.modulo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.modulo.exception.ResourceNotFoundException;
import com.prueba.modulo.model.CurrencyPair;
import com.prueba.modulo.repository.CurrencyPairRepository;

@Service
@Transactional
public class CurrencyPairServiceImpl implements CurrencyPairService {

	@Autowired
	private CurrencyPairRepository currencyPairRepository;
	
	@Override
	public CurrencyPair createCurrencyPair(CurrencyPair currencyPair) {
		return currencyPairRepository.save(currencyPair);
	}
	
	@Override
	public CurrencyPair updateCurrencyPair(CurrencyPair currencyPair) {
		Optional<CurrencyPair> currencyPairDb = this.currencyPairRepository.findById(currencyPair.getId());
		
		if(currencyPairDb.isPresent()) {
			CurrencyPair currencyPairUpdate = currencyPairDb.get();
			currencyPairUpdate.setId(currencyPair.getId());
			
			currencyPairUpdate.setCurrencyOri(currencyPair.getCurrencyOri());
			currencyPairUpdate.setCurrencyDes(currencyPair.getCurrencyDes());
			
			currencyPairUpdate.setCurrencyPairOriId(currencyPair.getCurrencyPairOriId());
			currencyPairUpdate.setCurrencyPairDesId(currencyPair.getCurrencyPairDesId());
			
			currencyPairUpdate.setDescriptionCurrencyPair(currencyPair.getDescriptionCurrencyPair());
			currencyPairUpdate.setAbbreviationCurrencyPair(currencyPair.getAbbreviationCurrencyPair());
			currencyPairUpdate.setTypeOperationCurrencyPair(currencyPair.getTypeOperationCurrencyPair());		
			currencyPairRepository.save(currencyPairUpdate);
			return currencyPairUpdate;
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + currencyPair.getId());
		}			
	}
	
	@Override
	public List<CurrencyPair> getAllCurrencyPair() {
		return this.currencyPairRepository.findAll();
	}
	
	@Override
	public CurrencyPair getCurrencyPairById(String currencyPairId) {
		Optional<CurrencyPair> currencyPairDb = this.currencyPairRepository.findById(currencyPairId);
		if(currencyPairDb.isPresent()) {
			return currencyPairDb.get();
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + currencyPairId);
		}		
	}
	
	@Override
	public void deleteCurrencyPair(String currencyPairId) {
		Optional<CurrencyPair> currencyPairDb = this.currencyPairRepository.findById(currencyPairId);
		if(currencyPairDb.isPresent()) {
			this.currencyPairRepository.delete(currencyPairDb.get());
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + currencyPairId);
		}
		
	}
		
}
