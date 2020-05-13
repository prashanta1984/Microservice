package com.ibm.converstionfactorms.service;


import java.util.Optional;
import com.ibm.converstionfactorms.model.ConversionFactor;

public interface ConversionFactorService {
	public void addConversionFactor(ConversionFactor conversionFactor);
	public void updateConversionFactor(ConversionFactor conversionFactor);
	public Optional<ConversionFactor> getConversionFactorFromCurrencyCode(String currencyCode);
	
	
}
