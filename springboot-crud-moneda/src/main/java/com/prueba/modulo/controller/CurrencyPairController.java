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
import com.prueba.modulo.model.CurrencyPair;
import com.prueba.modulo.service.CurrencyPairService;

@RestController
public class CurrencyPairController {

	@Autowired
	private CurrencyPairService currencyPairService;
	
	@GetMapping("/currencyPairs")
	public ResponseEntity<List<CurrencyPair>> getAllCurrencyPair() {
		return ResponseEntity.ok().body(currencyPairService.getAllCurrencyPair());   
	}
	
	@GetMapping("/currencyPairs/{id}")
	public ResponseEntity<CurrencyPair> getCurrencyPairById(@PathVariable String id) {
		return ResponseEntity.ok().body(currencyPairService.getCurrencyPairById(id));   
	}

	@PostMapping("/currencyPairs")
	public ResponseEntity<CurrencyPair> createCurrencyPair(@RequestBody CurrencyPair currencyPair) {
		return ResponseEntity.ok().body(this.currencyPairService.createCurrencyPair(currencyPair));
	}

	@PutMapping("/currencyPairs/{id}")
	public ResponseEntity<CurrencyPair> updateCurrencyPair (@PathVariable String id, @RequestBody CurrencyPair currencyPair){
		currencyPair.setId(id);
		return ResponseEntity.ok().body(this.currencyPairService.updateCurrencyPair(currencyPair));
	}

	@DeleteMapping("/currencyPairs/{id}")
	public HttpStatus deleteCurrencyPair(@PathVariable String id){
		this.currencyPairService.deleteCurrencyPair(id);
		return HttpStatus.OK;
	}
	
	
	
	
	
	
	
}
