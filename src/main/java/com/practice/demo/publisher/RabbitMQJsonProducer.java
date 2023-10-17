package com.practice.demo.publisher;

import com.practice.demo.dtos.ProductDTO;
import com.practice.demo.dtos.ProductOnlyDTO;
import com.practice.demo.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.json.key}")
    private String jsonRoutingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);
    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(ProductOnlyDTO product){
        LOGGER.info(String.format("Product Json: %s", product.toString()));
        rabbitTemplate.convertAndSend(exchangeName, jsonRoutingKey, product);
    }
}
