package com.prueba.modulo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.modulo.exception.ResourceNotFoundException;
import com.prueba.modulo.model.CurrencyPair;
import com.prueba.modulo.model.ExchangeRate;
import com.prueba.modulo.model.ParamExchange;
import com.prueba.modulo.model.ResultExchange;
import com.prueba.modulo.repository.ExchangeRateRepository;
import com.prueba.modulo.repository.CurrencyPairRepository;

@Service
@Transactional
public class ExchangeRateServiceImpl implements ExchangeRateService {

	@Autowired
	private ExchangeRateRepository exchangeRateRepository;
	
	@Autowired
	private CurrencyPairRepository currencyPairRepository;
	
	@Override
	public ExchangeRate createExchangeRate(ExchangeRate exchangeRate) {
		return exchangeRateRepository.save(exchangeRate);
	}
	
	@Override
	public ExchangeRate updateExchangeRate(ExchangeRate exchangeRate) {
		Optional<ExchangeRate> exchangeRateDb = this.exchangeRateRepository.findById(exchangeRate.getId());
		
		if(exchangeRateDb.isPresent()) {
			ExchangeRate exchangeRateUpdate = exchangeRateDb.get();
			exchangeRateUpdate.setId(exchangeRate.getId());
			exchangeRateUpdate.setCurrencyPair(exchangeRate.getCurrencyPair());
			exchangeRateUpdate.setDateExchangeRate(exchangeRate.getDateExchangeRate());
			exchangeRateUpdate.setAmountExchangeRate(exchangeRate.getAmountExchangeRate());			
			exchangeRateUpdate.setCurrencyPairIdem(exchangeRate.getCurrencyPairIdem());
			
			return exchangeRateUpdate;
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + exchangeRate.getId());
		}
	}
	
	@Override
	public List<ExchangeRate> getAllExchangeRate() {
		return this.exchangeRateRepository.findAll();
	}
	
	@Override
	public ExchangeRate getExchangeRateById(String exchangeRateId) {
		Optional<ExchangeRate> exchangeRateDb = this.exchangeRateRepository.findById(exchangeRateId);
		if (exchangeRateDb.isPresent()) {
			return exchangeRateDb.get();
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + exchangeRateId);
		}		
	}
	
	@Override
	public void deleteExchangeRate(String exchangeRateId) {
		Optional<ExchangeRate> exchangeRateDb = this.exchangeRateRepository.findById(exchangeRateId);
		if(exchangeRateDb.isPresent()) {
			this.exchangeRateRepository.delete(exchangeRateDb.get());
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + exchangeRateId);			
		}		
	}
		
	@Override
	public ResultExchange calcExchangeRate(ParamExchange paramExchange) {
		BigDecimal limitemonto = new BigDecimal(10200);
		if ( paramExchange.getMonto().compareTo(limitemonto) > 0) {
			throw new ResourceNotFoundException("El monto ingresado no puede ser mayor de : " + limitemonto.toString());			
		}
		
		int scale = 2;		
		BigDecimal encontradoAmountExchangeRate = BigDecimal.ZERO;
		BigDecimal calculoMontocontipocambio = BigDecimal.ZERO;
		
		ResultExchange resultExchangeNuevo = new ResultExchange();
		
		resultExchangeNuevo.setMonto(paramExchange.getMonto());
		resultExchangeNuevo.setMonedaorigen(paramExchange.getMonedaorigen());
		resultExchangeNuevo.setMonedadestino(paramExchange.getMonedadestino());
		
		CurrencyPair encontradoCurrencyPair2 = new CurrencyPair();  
		String buscarCurrencyPair = "";
		buscarCurrencyPair = paramExchange.getMonedaorigen() + "/" + paramExchange.getMonedadestino();
		List<CurrencyPair> lstCurrencyPair = currencyPairRepository.findAll();
		for(CurrencyPair regCurrencyPair : lstCurrencyPair) {			
			if(regCurrencyPair.getAbbreviationCurrencyPair().equals(buscarCurrencyPair)) {
				Optional<CurrencyPair> encontradoCurrencyPair = currencyPairRepository.findById(regCurrencyPair.getId());
				if(encontradoCurrencyPair.isPresent()) {					
					encontradoCurrencyPair2 = encontradoCurrencyPair.get();
					break;
				}				
			}			
		}
		String idCurrencyPair = "";
		String typeOperationCurrencyPair = "";
		if(encontradoCurrencyPair2 != null) {
			idCurrencyPair = encontradoCurrencyPair2.getId();
			typeOperationCurrencyPair = encontradoCurrencyPair2.getTypeOperationCurrencyPair();
		}
		if(idCurrencyPair != "" && idCurrencyPair != null) {
			Calendar cal = Calendar.getInstance();				
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			String fechaHoy = format1.format(cal.getTime());  // 2022-11-19
			List<ExchangeRate> lstExchangeRate = exchangeRateRepository.findAll();
			for(ExchangeRate regExchangeRate : lstExchangeRate) {
				
				String fechaLista = format1.format(regExchangeRate.getDateExchangeRate().getTime());
				
				if (regExchangeRate.getCurrencyPairIdem().equals(idCurrencyPair) && fechaLista.equals(fechaHoy)) {
					encontradoAmountExchangeRate = regExchangeRate.getAmountExchangeRate(); 
					break;
				}								
			}
			if ("/".equals(typeOperationCurrencyPair)) { 				
				calculoMontocontipocambio = paramExchange.getMonto().divide(encontradoAmountExchangeRate, scale, RoundingMode.CEILING);
			} else { 
				calculoMontocontipocambio = paramExchange.getMonto().multiply(encontradoAmountExchangeRate.setScale(2, RoundingMode.HALF_UP));
			}
		}
		resultExchangeNuevo.setTipodecambio(encontradoAmountExchangeRate);
		resultExchangeNuevo.setMontocontipocambio(calculoMontocontipocambio);
		
		return resultExchangeNuevo;
	}
	
}
