package com.softtwig.product.config;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;


import org.springframework.amqp.core.AcknowledgeMode;


@Configuration
public class RabbitMQConfig {
	
	 public static final String QUEUE_NAME = "FinalProductQueue";
	    public static final String DLQ_NAME = "productDLQ";
	    public static final String EXCHANGE_NAME = "productExchange";
	    public static final String ROUTING_KEY = "productRoutingKey";
	    public static final String DLQ_ROUTING_KEY = "productRoutingKey.dlq";

	
	    
	    @Bean
	    public Queue dlq() {
	        return QueueBuilder.durable(DLQ_NAME).build();
	    }

	   
	     
	

    @Bean
    public Queue queue() {
    	return QueueBuilder.durable(QUEUE_NAME)
                .withArgument("x-dead-letter-exchange", EXCHANGE_NAME)
                .withArgument("x-dead-letter-routing-key", DLQ_ROUTING_KEY)
                .withArgument("x-message-ttl", 60000)
                .build();

    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
    
    @Bean
    Binding dlqBinding(Queue dlq, TopicExchange exchange) {
        return BindingBuilder.bind(dlq).to(exchange).with(DLQ_ROUTING_KEY);
    }
    
    
    
    @Bean
    SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setRetryTemplate(retryTemplate());
        return factory;
    }


    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
     
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(3);

       
        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
        backOffPolicy.setBackOffPeriod(60000); 
        
        retryTemplate.setRetryPolicy(retryPolicy);
        retryTemplate.setBackOffPolicy(backOffPolicy);
        
        
        
        return retryTemplate;
    }


    
    
}