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

import com.prueba.modulo.model.Currency;
import com.prueba.modulo.service.CurrencyService;

@RestController
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;
	
	@GetMapping("/currencys")
	public ResponseEntity<List<Currency>> getAllCurrency(){
		return ResponseEntity.ok().body(currencyService.getAllCurrency());		
	}

	@GetMapping("/currencys/{id}")
	public ResponseEntity<Currency> getCurrencyById(@PathVariable String id){
		return ResponseEntity.ok().body(currencyService.getCurrencyById(id));		
	}
	
	@PostMapping("/currencys")
	public ResponseEntity<Currency> createCurrency(@RequestBody Currency currency){
		return ResponseEntity.ok().body(this.currencyService.createCurrency(currency));
	}
	
	@PutMapping("/currencys/{id}")
	public ResponseEntity<Currency> updateCurrency(@PathVariable String id, @RequestBody Currency currency){		
		currency.setId(id);
		return ResponseEntity.ok().body(this.currencyService.updateCurrency(currency));
	}
	
	@DeleteMapping("/currencys/{id}")
	public HttpStatus deleteCurrency(@PathVariable String id){
		this.currencyService.deleteCurrency(id);
		return HttpStatus.OK;
	}
	
}
