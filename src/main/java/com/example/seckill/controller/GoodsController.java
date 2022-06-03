package com.example.seckill.controller;

import com.example.seckill.pojo.User;
import com.example.seckill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created on 2022/5/31.
 *
 * @author Ann Zhou
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping("/toList")
    public String toList(Model model, User user){
//         if(StringUtils.isEmpty(ticket)){
//             return "login";
//         }
//        // User user = (User)session.getAttribute(ticket);
//        User user=iUserService.getUserByCookie(ticket,request,response);
//         if(null==user)return "login";

         model.addAttribute("user",user);
         return "goodsList";
    }
}
