package com.prueba.modulo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.modulo.model.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, String> {

}
