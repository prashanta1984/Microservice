package com.ibm.currencyconversionms.model;

public class CurrencyConversionRequest {
	
	double amount;
	String fromcurrency;
	String toCurrency;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getFromcurrency() {
		return fromcurrency;
	}
	public void setFromcurrency(String fromcurrency) {
		this.fromcurrency = fromcurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	
	
}
