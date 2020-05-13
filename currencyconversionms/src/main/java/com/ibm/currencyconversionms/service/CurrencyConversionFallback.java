package com.ibm.currencyconversionms.service;

import org.springframework.stereotype.Component;

import com.ibm.currencyconversionms.model.CurrencyConversionBean;
import com.ibm.currencyconversionms.model.CurrencyConversionRequest;

@Component
public class CurrencyConversionFallback implements CurrencyExchangeServiceProxy{

	
	
	@Override
	public CurrencyConversionBean calculateConversionAmount(CurrencyConversionRequest currencyConversionRequestRequest) {
		// TODO Auto-generated method stub
		return new CurrencyConversionBean(currencyConversionRequestRequest.getAmount(), currencyConversionRequestRequest.getFromcurrency(),currencyConversionRequestRequest.getToCurrency());
	}

	@Override
	public CurrencyConversionBean getCoversionAmount(Double amount, String fromcurrency, String tocurrency) {
		// TODO Auto-generated method stub
		return new CurrencyConversionBean(amount, fromcurrency,tocurrency);
	}

}
