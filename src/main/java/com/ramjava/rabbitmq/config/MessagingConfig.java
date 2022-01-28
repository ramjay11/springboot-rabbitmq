package com.ramjava.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;

@Configuration
public class MessagingConfig {

	public Queue queue() {
		return new Queue("ramjava_queue");
	}
	
	public TopicExchange exchange() {
		return new TopicExchange("ramjava_exchange");
	}
	
	// Bind queue and exchange
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("ramjava_routingKey");
	}
}
