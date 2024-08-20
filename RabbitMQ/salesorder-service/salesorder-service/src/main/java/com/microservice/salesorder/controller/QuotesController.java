package com.microservice.salesorder.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.salesorder.been.QuotesBO;
import com.microservice.salesorder.service.QuotesService;
 @CrossOrigin(origins="*")
@RestController
@RequestMapping("/salesorder/quotes")
public class QuotesController {

	@Autowired
	private QuotesService quotesService;
	
	
	@PostMapping("/create-quotes")
	public ResponseEntity<?> createQuotes(@RequestBody QuotesBO quotesBo ,HttpServletRequest request){
		
		try {
			quotesBo = quotesService.createQuotes(quotesBo);	
			
			if(quotesBo!=null ) {
				
				return ResponseEntity.ok(quotesBo);			
			}
			
		}
		catch (Exception e) {
			return  (ResponseEntity<?>) ResponseEntity.badRequest();
		}
		
		return  (ResponseEntity<?>) ResponseEntity.badRequest();
	}
	
	
		
}
	 
