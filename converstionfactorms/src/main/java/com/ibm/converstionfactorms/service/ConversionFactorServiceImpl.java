package com.ibm.converstionfactorms.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.converstionfactorms.exception.ResourceExistsException;
import com.ibm.converstionfactorms.exception.ResourceNotFoundException;
import com.ibm.converstionfactorms.model.ConversionFactor;
import com.ibm.converstionfactorms.repository.ConversionFactorRepository;

@Service
@Transactional
public class ConversionFactorServiceImpl implements ConversionFactorService {
	private static final Logger log = LoggerFactory.getLogger(ConversionFactorServiceImpl.class);
	
	@Autowired
	ConversionFactorRepository conversionFactoryRepo;
	
	
	
	@Override
	public void addConversionFactor(ConversionFactor conversionFac) {
		// TODO Auto-generated method stub
		

		Optional<ConversionFactor> coversionfactor = getConversionFactorFromCurrencyCode(conversionFac.getCurrencyCode());
		if(!coversionfactor.isPresent()) {

		    
		    conversionFac.setCountryCode(conversionFac.getCountryCode());
		    conversionFac.setCurrencyCode(conversionFac.getCurrencyCode());
		    conversionFac.setFactor(conversionFac.getFactor());
			log.info("ConversionFactor successfully created");
			
				
			conversionFactoryRepo.save(conversionFac);
		}else {
			log.info ("ConversionFactor Already exists!!");
			
			  throw new ResourceExistsException("ConversionFactor Already exists!!");
			 
		}
		
	}

	@Override
	public void updateConversionFactor(ConversionFactor updateConversionFactor) {
		// TODO Auto-generated method stub
		Optional<ConversionFactor> coversionfactor = getConversionFactorFromCurrencyCode(updateConversionFactor.getCurrencyCode());
		ConversionFactor conversionFact= new ConversionFactor();
		if(coversionfactor.isPresent()) { 
			conversionFact = coversionfactor.get();
			conversionFact.setCountryCode(updateConversionFactor.getCountryCode());
			conversionFact.setCurrencyCode(updateConversionFactor.getCurrencyCode());
			conversionFact.setFactor(updateConversionFactor.getFactor());
			
		}
		else 
		{
			 throw new ResourceNotFoundException("ConversionFactor does not exits");
		  
		}
		
		conversionFactoryRepo.save(conversionFact);
	}

	@Override
	public Optional<ConversionFactor> getConversionFactorFromCurrencyCode(String currencyCode) {
		// TODO Auto-generated method stub
		return conversionFactoryRepo.findByCurrencyCode(currencyCode);
		
	}

	

	/*
	 * @Override public ConversionFactor getConvertionValueByFromAndTo(String
	 * fromcurrencycode, String tocurrencycode) { // TODO Auto-generated method stub
	 * //return conversionFactoryRepo.findByFromAndTo(fromcurrencycode,
	 * tocurrencycode); }
	 */
	

}
