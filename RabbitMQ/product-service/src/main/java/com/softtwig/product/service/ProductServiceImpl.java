package com.softtwig.product.service;

import org.springframework.stereotype.Service;

@Service

public class ProductServiceImpl implements ProductService {

	

	@Override
	public int createException(int productId, int orderedUnit) throws NumberFormatException {

        
		try {

			System.out.println("------------------ this is service layer ------------------------");
			
			
//			throw new NumberFormatException();

		}

		catch( NumberFormatException n){
			throw n;
			
		}
		    catch(Exception e) {
		    	
		    	System.out.println("Exception in service Layer");
    	
		    }

		return 0;
	}

	

}
