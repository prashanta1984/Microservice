package com.ibm.currencyconversionms.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ibm.currencyconversionms.model.CurrencyConversionBean;
import com.ibm.currencyconversionms.model.CurrencyConversionRequest;
import com.ibm.currencyconversionms.service.CalculateCoversionService;
import com.ibm.currencyconversionms.service.CurrencyExchangeServiceProxy;



@RestController
@RequestMapping(value="/currency")
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CalculateCoversionService calCoversionService;
	
	@Autowired
	CurrencyExchangeServiceProxy CurrencyExchangeServiceProxy;

	/**/
	@PostMapping(value = "/conversion", headers="Accept=application/json")
	
	public CurrencyConversionBean convertCurrencyFeign(@RequestBody CurrencyConversionRequest request )
			 {

		CurrencyConversionBean response = calCoversionService.calculateCoversionAmount(request);

		logger.info("{}", response);
		
		return response;
	}
	
     @GetMapping(value = "/conversion/{amount}/{fromcurrency}/{tocurrency}")
	
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable("amount") String amount,@PathVariable("fromcurrency") String fromcurrency, @PathVariable("tocurrency") String tocurrency )
			 {

		CurrencyConversionBean response = CurrencyExchangeServiceProxy.getCoversionAmount(Double.parseDouble(amount), fromcurrency, tocurrency);
    	// CurrencyConversionBean response=	 calCoversionService.getCoversionAmount(Double.parseDouble(amount), fromcurrency, tocurrency);
		logger.info("{}", response);
		
		return response;
	}

}
