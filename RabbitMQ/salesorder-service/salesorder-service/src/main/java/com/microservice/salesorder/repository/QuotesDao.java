package com.microservice.salesorder.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import org.springframework.data.domain.Page;

import com.microservice.salesorder.entity.QuotesEntity;

public interface QuotesDao {

	QuotesEntity createQuotes(QuotesEntity quotesVo);
	String generateUnique5DigitNumber();
	

}
