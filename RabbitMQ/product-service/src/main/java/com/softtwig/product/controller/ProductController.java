package com.softtwig.product.controller;

import org.springframework.messaging.handler.annotation.Header;
import java.util.Map;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtwig.product.config.RabbitMQConfig;
import com.softtwig.product.service.ProductService;
import com.rabbitmq.client.Channel;
@RestController
@RequestMapping("product")
@CrossOrigin(origins = "*")
@Endpoint(id = "product-endpoint")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private RabbitMQConfig rabbitconfig;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	
	
	
	@RabbitListener(queues = "FinalProductQueue")
	public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws Exception {
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        Map<String, Object> messagePayload = objectMapper.readValue(message, new TypeReference<Map<String, Object>>() {});
	        
	        int productId = (int) messagePayload.get("productId");
	        int orderedUnit = (int) messagePayload.get("orderedUnit");
	        System.out.println("Received ProductId: " + productId);
	        System.out.println("Received OrderedUnit: " + orderedUnit);
        
	        int a=productService.createException(productId,orderedUnit);
     
            System.out.println("Received ProductId : -- it will pass the line no 54 when there is not exception " + productId);
	        System.out.println("Received OrderedUnit: - it will pass the line no 54 when there is not exception " + orderedUnit);
	      
	       
	    } catch (Exception e) {
	    	
	    	System.out.println(" catched!!!!");
	
	    
	    	throw e;

	    	
	    }
	}
	
}
