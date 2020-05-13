package com.ibm.currencyconversionms.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.currencyconversionms.model.CurrencyConversionBean;
import com.ibm.currencyconversionms.model.CurrencyConversionRequest;


@FeignClient(name = "conversionfactor",fallback = CurrencyConversionFallback.class)
@RibbonClient(name="conversionfactor")
public interface CurrencyExchangeServiceProxy {
	
	
	@RequestMapping(value = "/conversionfactor", method = RequestMethod.POST)
	public CurrencyConversionBean calculateConversionAmount(CurrencyConversionRequest currencyConversionRequestRequest);
    @GetMapping(value = "/conversionfactor/{amount}/{fromcurrency}/{tocurrency}")
	public CurrencyConversionBean getCoversionAmount( @PathVariable("amount") Double amount, @PathVariable("fromcurrency") String fromcurrency, @PathVariable("tocurrency") String tocurrency);

    
}
