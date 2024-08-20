package com.microservice.salesorder.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.salesorder.been.ProductListBo;
import com.microservice.salesorder.been.QuotesBO;
import com.microservice.salesorder.config.MessageSender;
import com.microservice.salesorder.entity.ProductListVo;
import com.microservice.salesorder.entity.QuotesEntity;
import com.microservice.salesorder.repository.QuotesDao;

@Service
@Transactional
public class QuotesServiceImpl implements QuotesService{
@Autowired
	private QuotesDao quotesDao;

@Autowired
private MessageSender messageSender;




@Override
	public QuotesBO createQuotes(QuotesBO quotesBo) {
	

    QuotesEntity quotesVo = new QuotesEntity();
    LocalDateTime datetime1 = LocalDateTime.now();  
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
    String formatDateTime = datetime1.format(format); 
    
    try {
        BeanUtils.copyProperties(quotesBo, quotesVo);
        
        quotesVo.setCreationDate(quotesBo.getCreationDate());
        quotesVo.setIsDelete(false);
        quotesVo.setAssignedTo(quotesBo.getCreatedBy());
        quotesVo.setCreatedBy(quotesBo.getCreatedBy());
        quotesVo.setQuotesUniNumber(quotesDao.generateUnique5DigitNumber());
        
        List<ProductListVo> productListVoList = new ArrayList<>();
        for (ProductListBo productBo : quotesBo.getProductListArr()) {
            ProductListVo productVo = new ProductListVo();
            BeanUtils.copyProperties(productBo, productVo);
            productVo.setQuotes(quotesVo);
            productListVoList.add(productVo);
        }
        quotesVo.setProductListArr(productListVoList);
        
        quotesVo = quotesDao.createQuotes(quotesVo);
        if (quotesVo != null) {
            BeanUtils.copyProperties(quotesVo, quotesBo);
            quotesBo.setQuotesUni(quotesVo.getQuotesUniNumber());
            
            
            List<ProductListBo> productListBoList = new ArrayList<>();
            
            
            for( ProductListVo vo : quotesVo.getProductListArr()    ) {
            	ProductListBo bo = new ProductListBo();
            	BeanUtils.copyProperties(vo, bo);
            	
            	Map<String, Object> messagePayload = new HashMap<>();
            	messagePayload.put("productId", bo.getProductId());
            	messagePayload.put("orderedUnit", bo.getUnitRequired());
            	
            	 messageSender.sendProductMessage(messagePayload);
            	productListBoList.add(bo);
            	
            	
            }
            
            quotesBo.setProductListArr(productListBoList);
            
            
            return quotesBo;
        }
    } catch (Exception e) {
       
        e.printStackTrace();
    }
    return null;
	

	}
	

	

	

}
