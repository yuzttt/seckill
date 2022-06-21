package com.example.seckill.config;

import com.example.seckill.pojo.User;

/**
 * Created on 2022/6/20.
 *
 * @author Ann Zhou
 */
public class userContext {

    private static ThreadLocal<User> userHolder = new ThreadLocal<>();

    public static void setUser(User user){
        userHolder.set(user);
    }

    public static User getUser(){
        return  userHolder.get();
    }
}
