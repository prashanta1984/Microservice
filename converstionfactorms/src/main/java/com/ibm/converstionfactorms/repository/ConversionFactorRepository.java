package com.ibm.converstionfactorms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ibm.converstionfactorms.model.ConversionFactor;


@Repository
public interface ConversionFactorRepository extends JpaRepository<ConversionFactor, Long>{
	//ConversionFactor findByFromAndTo(String from, String to);
	Optional<ConversionFactor> findByCurrencyCode(String name);
	
}
