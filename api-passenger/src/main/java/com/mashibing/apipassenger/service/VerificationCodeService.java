package com.mashibing.apipassenger.service;


import com.mashibing.apipassenger.remote.ServiceVerificationClient;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import com.mashibing.internalcommon.response.TokenResponse;
import io.netty.util.internal.StringUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeService {

    @Autowired
    private ServiceVerificationClient serviceVerificationClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String api_passenger_prefix = "api-passenger";

    public static String generateKeyByPhone(String passenger) {
        return api_passenger_prefix + passenger;
    }

    //实现一个方法，根据手机号调用“验证码服务”，并获取返回的验证码，存入redis
    public ResponseResult generateCode(String passengerPhone){

        System.out.println("调用验证码服务，获取验证码");
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationClient.getNumberCode(6); //业务服务暂时写死
        int numberCode = numberCodeResponse.getData().getNumberCode();
        System.out.println("验证码：" + numberCode);

        System.out.println("存入redis");
        //redis需要key，value(就是验证码)和过期时间
        String key = generateKeyByPhone(passengerPhone);
        stringRedisTemplate.opsForValue().set(key, String.valueOf(numberCode), 2, TimeUnit.MINUTES);

        /**
         * 使用Response类代替Json类返回
         *         JSONObject result = new JSONObject();
         *         result.put("code",1);
         *         result.put("message","success");
         */

        // 还需要通过短信服务商，将验证码发送给对应的用户，一般是通过三方的短信平台来发送的
        //todo
        return ResponseResult.success("");

    }

    public ResponseResult checkCode(String passengerPhone, String verificationCode){

        //获取验证码
        String key = generateKeyByPhone(passengerPhone);
        String codeRedis = stringRedisTemplate.opsForValue().get(key);
        System.out.println("获取的验证码: "+codeRedis);

        //验证验证码：为空已过期；输入不正确
        if (StringUtils.isBlank(codeRedis)) {
            return ResponseResult.fail("验证码已过期");
        }
        if (!verificationCode.trim().equals(codeRedis.trim())) {
            return ResponseResult.fail("验证码不正确");
        }

        System.out.println("判断原来是否有该用户，并作进一步处理");


        System.out.println("颁发token");

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken("token string");

        return ResponseResult.success(tokenResponse);
    }
}
