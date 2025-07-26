package com.mashibing.apipassenger.controller;

import com.mashibing.apipassenger.request.VerificationCodeDTO;
import com.mashibing.apipassenger.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;


@PostMapping("/verification-code")
    public String verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){

        String PassengerPhone = verificationCodeDTO.getPassengerPhone();
        System.out.println("接受到的手机号："+PassengerPhone);

        //在service层实现业务逻辑
        return verificationCodeService.generateCode(PassengerPhone);


    }
}
