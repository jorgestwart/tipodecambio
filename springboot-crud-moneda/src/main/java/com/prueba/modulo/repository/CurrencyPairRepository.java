package com.prueba.modulo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.modulo.model.CurrencyPair;

public interface CurrencyPairRepository extends JpaRepository<CurrencyPair, String> {

}
