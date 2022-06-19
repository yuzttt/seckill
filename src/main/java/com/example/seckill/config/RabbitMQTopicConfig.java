package com.example.seckill.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.PublisherCallbackChannel;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2022/6/11.
 *
 * @author Ann Zhou
 */
@Configuration
public class RabbitMQTopicConfig {
    private static final String QUEUE = "seckillQueue";
    private static final String EXCHANGE = "seckillExchange";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(topicExchange()).with("seckill.#");
    }



}
