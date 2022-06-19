package com.example.seckill.rabbitMQ;

import com.example.seckill.pojo.Order;
import com.example.seckill.pojo.SeckillMessage;
import com.example.seckill.pojo.SeckillOrder;
import com.example.seckill.pojo.User;
import com.example.seckill.service.IGoodsService;
import com.example.seckill.service.IOrderService;
import com.example.seckill.utils.JsonUtils;
import com.example.seckill.vo.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/**
 * Created on 2022/6/10.
 *
 * @author Ann Zhou
 */
@Service
@Slf4j
public class MQReceiver {
    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IOrderService orderService;

    //    @RabbitListener(queues="queue")
//    public void receive(Object msg){
//        log.info("接收消息："+msg);
//    }
//    @RabbitListener(queues="queue_fanout01")
//    public void receive01(Object msg){
//        log.info("QUEUE01接收消息："+msg);
//    }
//    @RabbitListener(queues="queue_fanoout02")
//    public void receive02 (Object msg){
//        log.info("QUEUE02接收消息："+msg);
//    }
    @RabbitListener(queues = "seckillQueue")
    public void receive(String message) {

        log.info("接收消息：" + message);
        SeckillMessage seckillMessage = JsonUtils.jsonStr2Object(message, SeckillMessage.class);
        assert seckillMessage != null;
        Long goodsId = seckillMessage.getGoodsId();
        User user = seckillMessage.getUser();
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        //判断是否重复抢购
        String seckillOrderJson = (String)redisTemplate.opsForValue().get("order:" + user.getId() + ":" + goodsId);

        if (!StringUtils.isEmpty(seckillOrderJson)) {
            return;
        }
        //下单
        orderService.secKill(user, goodsVo);

        //是否下单成功的查询


    }


}
