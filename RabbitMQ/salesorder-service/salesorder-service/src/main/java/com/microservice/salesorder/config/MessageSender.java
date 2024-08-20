package com.microservice.salesorder.config;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.salesorder.been.ProductListBo;
import com.microservice.salesorder.been.QuotesBO;
import com.microservice.salesorder.entity.ProductListVo;

@Service
public class MessageSender {
	
	
	
	@Autowired
    private AmqpTemplate amqpTemplate;
	
	
	 @Autowired
	    private RabbitTemplate rabbitTemplate;

	    @Autowired
	    private RabbitMQConfig rabbitMQConfig;

	    @Autowired
	    private ObjectMapper objectMapper; 

	    public void sendMessage(QuotesBO quotesBO) {
	        try {
	            String jsonMessage = objectMapper.writeValueAsString(quotesBO);
	            rabbitTemplate.convertAndSend(rabbitMQConfig.EXCHANGE_NAME, rabbitMQConfig.ROUTING_KEY, jsonMessage);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	    
	        }
	    }

		public void sendProductMessage(Map<String, Object> messagePayload) {
		
			 try {
		            String jsonMessage = objectMapper.writeValueAsString(messagePayload);
		            rabbitTemplate.convertAndSend(rabbitMQConfig.EXCHANGE_NAME, rabbitMQConfig.ROUTING_KEY, jsonMessage);
		        } catch (JsonProcessingException e) {
		            e.printStackTrace();
		          
		        }
			
			
			
		}

}
