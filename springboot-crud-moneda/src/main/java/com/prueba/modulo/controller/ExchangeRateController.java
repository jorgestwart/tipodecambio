package com.prueba.modulo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.modulo.model.CurrencyPair;
import com.prueba.modulo.model.ExchangeRate;
import com.prueba.modulo.model.ParamExchange;
import com.prueba.modulo.model.ResultExchange;
import com.prueba.modulo.service.ExchangeRateService;

@RestController
public class ExchangeRateController {

	@Autowired
	private ExchangeRateService exchangeRateService;
	
	@GetMapping("/exchangeRates")
	public ResponseEntity<List<ExchangeRate>> getAllExchangeRate(){
		return ResponseEntity.ok().body(exchangeRateService.getAllExchangeRate());
	}
	
	@GetMapping("/exchangeRates/{id}")
	public ResponseEntity<ExchangeRate> getExchangeRateById(@PathVariable String id){
		return ResponseEntity.ok().body(exchangeRateService.getExchangeRateById(id));		
	}
	
	@PostMapping("/exchangeRates")
	public ResponseEntity<ExchangeRate> createExchangeRate(@RequestBody ExchangeRate exchangeRate) {
		return ResponseEntity.ok().body(this.exchangeRateService.createExchangeRate(exchangeRate));		
	}

	@PutMapping("/exchangeRates/{id}")
	public ResponseEntity<ExchangeRate> updateExchangeRate(@PathVariable String id, @RequestBody ExchangeRate exchangeRate) {
		exchangeRate.setId(id);
		return ResponseEntity.ok().body(this.exchangeRateService.updateExchangeRate(exchangeRate));
	} 
	
	@DeleteMapping("/exchangeRates/{id}")
	public HttpStatus deleteExchangeRate(@PathVariable String id){
		this.exchangeRateService.deleteExchangeRate(id);
		return HttpStatus.OK;
	}

	@PostMapping("/calcExchangeRates")
	public ResponseEntity<ResultExchange> calcExchangeRate(@RequestBody ParamExchange paramExchange) {
		return ResponseEntity.ok().body(this.exchangeRateService.calcExchangeRate(paramExchange));		
	}

	
	
}
