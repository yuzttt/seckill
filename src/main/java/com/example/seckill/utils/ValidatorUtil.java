package com.example.seckill.utils;

import org.thymeleaf.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 2022/5/31.
 *
 * @author Ann Zhou
 */
public class ValidatorUtil {

    private static final Pattern mobile_pattern=Pattern.compile(
            "[1]([3-9])[0-9]{9}$"
    );

    public static boolean isMobile(String mobile){
        if(StringUtils.isEmpty(mobile)){
            return false;
        }
        Matcher matcher=mobile_pattern.matcher(mobile);
        return matcher.matches();
    }
}