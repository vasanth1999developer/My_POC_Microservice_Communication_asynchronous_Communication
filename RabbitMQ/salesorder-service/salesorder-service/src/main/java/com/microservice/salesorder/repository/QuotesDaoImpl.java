package com.microservice.salesorder.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.microservice.salesorder.entity.QuotesEntity;

@Repository
public class QuotesDaoImpl implements QuotesDao{
	
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private QuotesRepository quotesRepository ;

	@Override
	public QuotesEntity createQuotes(QuotesEntity quotesVo) {
	try {
			entityManager.persist(quotesVo);
			if(0!=quotesVo.getQuotesId()) {
					return quotesVo;
			}
			}
		catch(Exception e) {
			e.printStackTrace();
			}
		return null;
	}
	
	
		
	
public String generateUnique5DigitNumber() {
		
	try {
      
        Query query = entityManager.createQuery("SELECT q.quotesUniNumber FROM QuotesEntity q WHERE q.quotesId = (SELECT MAX(q2.quotesId) FROM QuotesEntity q2)");
        query.setMaxResults(1);
        
        String lastQuotesUniNumber = (String) query.getSingleResult();
        
        if (lastQuotesUniNumber != null && lastQuotesUniNumber.startsWith("CRM")) {
            
            String numericPart = lastQuotesUniNumber.substring(3);
            
           
            int number = Integer.parseInt(numericPart) + 1;
            
            
            String newQuotesUniNumber = "CRM" + number;
            
            return newQuotesUniNumber;
        } else {
           
            return "CRM10001"; 
        }
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
           
    }

    


	
	
	
	

}
