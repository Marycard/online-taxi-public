package com.mashibing.serviceverification.controller;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")
    /**
     * 使用@PathVariable，读取路径中的参数
     */
    public ResponseResult numberCode(@PathVariable("size") int size) {
        System.out.println("size" + size);

        //生成验证码
        double mathRandom = (Math.random() * 10 + 1) * Math.pow(10, size-1);
        int resultInt = (int) mathRandom;
        System.out.println(resultInt);
        /**
         * 在工程上，返回的结果肯定不是使用这个json方式定义，不符合高内聚低耦合，也不符合实现对增改开放的原则
         * 可以使用一个公共类，里面专门存放公用数据，方便封装返回结果
         *         JSONObject result = new JSONObject();
         *         result.put("code", 1);
         *         result.put("message", "success");
         *         JSONObject data = new JSONObject();
         *         data.put("numberCode", resultInt);
         *         result.put("data", data);
         */
        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(resultInt);

        return ResponseResult.success(response);
    }

    public static void main(String[] args) {
        //在main里面测试方法
        double mathRandom = Math.random();
        System.out.println((mathRandom * 10 + 1) * Math.pow(10, 6-1));

    }
}