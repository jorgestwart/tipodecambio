package com.prueba.modulo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.modulo.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, String> {

}
