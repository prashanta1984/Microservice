package com.ibm.converstionfactorms.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.converstionfactorms.model.ConversionFactor;
import com.ibm.converstionfactorms.model.ConversionFactorResponse;
import com.ibm.converstionfactorms.model.CurrencyConversionBean;
import com.ibm.converstionfactorms.model.CurrencyConversionRequest;
import com.ibm.converstionfactorms.repository.ConversionFactorRepository;
import com.ibm.converstionfactorms.service.ConversionFactorService;






@RestController
public class ConversionFactorController {
	
	  private Logger logger = LoggerFactory.getLogger(this.getClass());
	  
	  @Autowired 
	  private ConversionFactorRepository repository;
	  
	  @Autowired ConversionFactorService conversionFactorService;
	  
	  @GetMapping(value="/getConversionRequest",produces = MediaType.APPLICATION_JSON_VALUE)
		public CurrencyConversionRequest getConversionfactorRequest(){
			
			return  new  CurrencyConversionRequest();
			
		}
	  
	  
		@GetMapping(value="/getConversionfactor",produces = MediaType.APPLICATION_JSON_VALUE)
		public ConversionFactorResponse getConversionfactor(){
			List<ConversionFactor> coversionfactorlist=new ArrayList<>();
			
			coversionfactorlist=repository.findAll() ;
			ConversionFactorResponse conversionFactorResponse=new ConversionFactorResponse();
			for (ConversionFactor conversionFactor2 : coversionfactorlist) {
				
				conversionFactorResponse.setCountryCode(conversionFactor2.getCountryCode());
			
				conversionFactorResponse.setCurrencyCode(conversionFactor2.getCurrencyCode());
				
				conversionFactorResponse.setId(conversionFactor2.getId());
				conversionFactorResponse.setFactor(conversionFactor2.getFactor());
			}
			return  conversionFactorResponse;
			
		}
		
	  
	  
		@PostMapping(value = "/coversionfactor", headers="Accept=application/json")
		public CurrencyConversionBean retrieveConversionAmount
			(@RequestBody CurrencyConversionRequest request){
			
		  double coversionAmount=0;
			if(request.getFromcurrency().equalsIgnoreCase("USD"))
			{
				 coversionAmount=request.getAmount()*1.29;
			}
			
			CurrencyConversionBean response = new CurrencyConversionBean(coversionAmount,request.getFromcurrency(), request.getToCurrency());
			return response;
		}
		
		@GetMapping(value = "/conversionfactor/{amount}/{fromcurrency}/{tocurrency}")
	    public CurrencyConversionBean getFromCurrencyToCurrencyFeign(@PathVariable("amount") Double amount,@PathVariable("fromcurrency") String fromcurrencycode,
	                                            @PathVariable("tocurrency") String tocurrencycode) {
		  
			double coversionAmount=0;
			if(fromcurrencycode.equalsIgnoreCase("USD"))
			{
				 coversionAmount=amount*1.29;
			}
			
			CurrencyConversionBean response = new CurrencyConversionBean(coversionAmount,fromcurrencycode, tocurrencycode);
			return response;
		}
	
	  @GetMapping(path = "/{fromcurrencycode}/{tocurrencycode}")
	    public String getFromCurrencyToCurrency(@PathVariable("fromcurrencycode") String fromcurrencycode,
	                                            @PathVariable("tocurrencycode") String tocurrencycode) {
		  BigDecimal conversionFactorFrom = conversionFactorService.getConversionFactorFromCurrencyCode(fromcurrencycode).get().getFactor();
		  BigDecimal conversionFactorTO= conversionFactorService.getConversionFactorFromCurrencyCode(tocurrencycode).get().getFactor();
	      
		  
		  return conversionFactorFrom+ "" +conversionFactorTO;
	    }
	  
	  @PostMapping(value="/create/conversionfactor",headers="Accept=application/json")
	  public ResponseEntity<?> createConversionFactor(@RequestBody ConversionFactor conversionfactor){
	  
		  logger.info(conversionfactor.toString());
	  
	  conversionFactorService.addConversionFactor(conversionfactor); return new
	  ResponseEntity<>("ConversionFactor " + " Created Successfully!!",
	  HttpStatus.CREATED); }
	  
	  @PutMapping(value="/update/conversionfactor",headers="Accept=application/json")
	  public ResponseEntity<ConversionFactor> updateUser(@RequestBody ConversionFactor conversionFactor) {
	  
	  logger.info("Current conversionfactor id is : {} ",conversionFactor.getId());
	  conversionFactorService.updateConversionFactor(conversionFactor); 
	  return new
	  ResponseEntity<ConversionFactor>(HttpStatus.OK); }
	  
	  
	  
	  
	  
	 }
