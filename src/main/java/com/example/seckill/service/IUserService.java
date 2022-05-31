package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.User;
import com.example.seckill.vo.LoginVo;
import com.example.seckill.vo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ann
 * @since 2022-05-30
 */
public interface IUserService extends IService<User> {

    RespBean doLogin(LoginVo loginVo);
}
