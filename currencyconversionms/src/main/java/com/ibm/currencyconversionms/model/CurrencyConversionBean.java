package com.ibm.currencyconversionms.model;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	public CurrencyConversionBean(double conversionAmount,String from, String to ) {
		super();
		this.from = from;
		this.to = to;
		this.conversionAmount = conversionAmount;
	}

	private String from;
	private String to;
	
	private double conversionAmount;
	
	public CurrencyConversionBean() {

	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public double getConversionAmount() {
		return conversionAmount;
	}

	public void setConversionAmount(double conversionAmount) {
		this.conversionAmount = conversionAmount;
	}

	

	

	

	

	


}
