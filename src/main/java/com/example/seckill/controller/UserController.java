package com.example.seckill.controller;


import com.example.seckill.pojo.User;
import com.example.seckill.rabbitMQ.MQSender;
import com.example.seckill.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ann
 * @since 2022-05-30
 */
@Controller
@RequestMapping("/user")
public class UserController {
//
//    @Autowired
//    private MQSender mqSender;
//
//    @RequestMapping("/info")
//    @ResponseBody
//    public RespBean info(User user){
//        return RespBean.success(user);
//    }
//
//    @RequestMapping("/mq")
//    @ResponseBody
//    public void mq(){
//       mqSender.send("Hello");
//    }
//
//    @RequestMapping("/mq/fanout")
//    @ResponseBody
//    public void mq01(){
//       mqSender.send("Hello");
//    }
}

