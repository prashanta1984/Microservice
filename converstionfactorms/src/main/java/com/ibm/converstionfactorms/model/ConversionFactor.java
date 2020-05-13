package com.ibm.converstionfactorms.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
@SequenceGenerator(name = "currency_id_seq", initialValue = 10001)
public class ConversionFactor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currency_id_seq")
	private Long id;
	private String currencyCode;
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
	private String countryCode;
	private BigDecimal factor;
	public ConversionFactor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConversionFactor(Long id, String currencycode, String countrycode, BigDecimal factor) {
		super();
		this.id = id;
		this.currencyCode = currencycode;
		this.countryCode = countrycode;
		this.factor = factor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public BigDecimal getFactor() {
		return factor;
	}
	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}
	

}
