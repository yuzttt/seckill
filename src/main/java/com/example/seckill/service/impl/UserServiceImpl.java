package com.example.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckill.exception.GlobalException;
import com.example.seckill.mapper.UserMapper;
import com.example.seckill.pojo.User;
import com.example.seckill.service.IUserService;
import com.example.seckill.utils.CookieUtil;
import com.example.seckill.utils.MD5;
import com.example.seckill.utils.UUIDUtil;
import com.example.seckill.utils.ValidatorUtil;
import com.example.seckill.vo.LoginVo;
import com.example.seckill.vo.RespBean;
import com.example.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ann
 * @since 2022-05-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
      String mobile=loginVo.getMobile();
      String password=loginVo.getPassword();
//      if(StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
//          return RespBean.error(RespBeanEnum.LOGIN_ERROR);
//      }
//
//      if(!ValidatorUtil.isMobile(mobile)){
//          return RespBean.error(RespBeanEnum.MOBILE_ERROR);
//      }

        User user = userMapper.selectById(mobile);
        if(null==user){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        if(!MD5.formPassToDBPass(password,user.getSalt()).equals(user.getPassword())){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);

        }
      //生产cookie
        String ticket = UUIDUtil.uuid();
        request.getSession().setAttribute(ticket,user);
        CookieUtil.setCookie(request,response,"userTicker",ticket);
      return RespBean.success();
    }
}
