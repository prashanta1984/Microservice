package com.ibm.currencyconversionms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ibm.currencyconversionms.model.CurrencyConversionBean;
import com.ibm.currencyconversionms.model.CurrencyConversionRequest;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
@Component

@RibbonClient(name = "conversionfactor")
public class CalculateCoversionService {
	
	@Autowired
	CurrencyExchangeServiceProxy discountProxy;
	
	@Autowired

	private DiscoveryClient discoveryClient;
	
	@Autowired
	LoadBalancerClient lbClient;
	
	public CurrencyConversionBean calculateCoversionAmount(CurrencyConversionRequest currencyConversionRequestRequest) {
		
		/*
		 * ServiceInstance instance = lbClient.choose("discountms"); String url =
		 * "http://" + instance.getHost() + ":" + instance.getPort() + "/caldisc";
		 */
		return discountProxy.calculateConversionAmount(currencyConversionRequestRequest);
		
		
		
	}
	@HystrixCommand(fallbackMethod ="coversionfallback")
	public CurrencyConversionBean getCoversionAmount(Double amount,String fromcurrency, String tocurrency)
	{
		return discountProxy.getCoversionAmount(amount, fromcurrency, tocurrency);
	}
	
	public CurrencyConversionBean  coversionfallback(CurrencyConversionRequest cRequest) {
		
		CurrencyConversionBean conversionBean = new CurrencyConversionBean();
		conversionBean.setConversionAmount(178);
		conversionBean.setFrom(cRequest.getFromcurrency());
		conversionBean.setTo(cRequest.getToCurrency());
		return conversionBean;
	}

}
