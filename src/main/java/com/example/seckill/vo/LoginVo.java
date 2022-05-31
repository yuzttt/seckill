package com.example.seckill.vo;

import com.example.seckill.Validator.isMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created on 2022/5/30.
 *
 * @author Ann Zhou
 */
@Data
public class LoginVo {
    @NotNull
    @isMobile
    private String mobile;
    @NotNull
    @Length(min=32)
    private String password;
}
