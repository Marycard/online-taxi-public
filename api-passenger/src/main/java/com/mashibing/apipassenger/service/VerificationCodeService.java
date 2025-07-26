package com.mashibing.apipassenger.service;


import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class VerificationCodeService {

    //实现一个方法，根据手机号调用“验证码服务”，并获取返回的验证码，存入redis
    public String generateCode(String passengerPhone){
        System.out.println("调用验证码服务，获取验证码");

        String code = "1234";

        System.out.println("存入redis");

        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("message","success");
        return result.toString();

    }
}
