package com.example.seckill.rabbitMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2022/6/10.
 *
 * @author Ann Zhou
 */
@Service
@Slf4j
public class MQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    public void send (Object msg){
//      log.info("发送消息："+msg);
//        rabbitTemplate.convertAndSend("fanoutExchange","",msg);
//    }

    public void sendSeckillMessage(String message){

        log.info("发送消息:"+message);
        rabbitTemplate.convertAndSend("seckillExchange","seckill.message",message);
    }
}
