package com.ibm.converstionfactorms.model;

import java.math.BigDecimal;

public class ConversionFactorResponse {

	private Long id;
	private String currencyCode;
	private String countryCode;
	private BigDecimal factor;
	
	public ConversionFactorResponse() {
	}
	public ConversionFactorResponse(Long id, String currencyCode, String countryCode, BigDecimal factor) {
		super();
		this.id = id;
		this.currencyCode = currencyCode;
		this.countryCode = countryCode;
		this.factor = factor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public BigDecimal getFactor() {
		return factor;
	}
	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}
	
}
