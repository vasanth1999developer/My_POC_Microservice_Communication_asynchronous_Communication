package com.microservice.salesorder.config;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
@Configuration
public class RabbitMQConfig {
	
	
	
	
	   public static final String QUEUE_NAME = "FinalProductQueue";
	    public static final String EXCHANGE_NAME = "productExchange";
	    public static final String ROUTING_KEY = "productRoutingKey";
	    public static final String DLQ_NAME = "productDLQ";
	    public static final String DEAD_LETTER_EXCHANGE = "DLX";
	    public static final String DLQ_ROUTING_KEY = "productRoutingKey.dlq";
	    
	    @Bean
	    public Queue exampleQueue() {
	    	Map<String, Object> args = new HashMap<>();
	        args.put("x-dead-letter-exchange", EXCHANGE_NAME);
	        args.put("x-dead-letter-routing-key", DLQ_ROUTING_KEY);
	        args.put("x-message-ttl", 86400000); 

	        return new Queue(QUEUE_NAME, true, false, false, args);
	    }

	    @Bean
	    public TopicExchange exampleExchange() {
	        return new TopicExchange(EXCHANGE_NAME);
	    }

	    @Bean
	    public Binding binding(Queue exampleQueue, TopicExchange exampleExchange) {
	        return BindingBuilder.bind(exampleQueue).to(exampleExchange).with(ROUTING_KEY);
	    }
	
	
	
	    @Bean
	    public ObjectMapper objectMapper() {
	        return new ObjectMapper();
	    }

	

}
