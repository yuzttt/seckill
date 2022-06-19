package com.example.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckill.mapper.SeckillOrderMapper;
import com.example.seckill.pojo.SeckillOrder;
import com.example.seckill.pojo.User;
import com.example.seckill.service.ISeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ann
 * @since 2022-06-03
 */
@Service
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements ISeckillOrderService {
   @Autowired
   private SeckillOrderMapper seckillOrderMapper;

   @Autowired
   private RedisTemplate redisTemplate;

    @Override
    public Long getResult(User user, Long goodsId) {

        SeckillOrder seckillOrder = seckillOrderMapper.selectOne(new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId));

        if (null != seckillOrder) {
            return seckillOrder.getOrderId();
        } else if (redisTemplate.hasKey("isStockEmpty" + goodsId)) {
            return -1L;
        }else{
            return 0L;
        }


    }
}
