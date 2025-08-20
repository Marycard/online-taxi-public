package com.mashibing.apipassenger.controller;

import com.mashibing.apipassenger.service.VerificationCodeService;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.VerificationCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;


@GetMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){

        String PassengerPhone = verificationCodeDTO.getPassengerPhone();
        System.out.println("接受到的手机号："+PassengerPhone);

        //在service层实现业务逻辑
        return verificationCodeService.generateCode(PassengerPhone);

    }
    @PostMapping("/verification-code-check")
    public ResponseResult verificationCodeCheck(@RequestBody VerificationCodeDTO verificationCodeDTO) {
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        String verificationCode = verificationCodeDTO.getVerificationCode();
        System.out.println("手机号：" + passengerPhone + "，验证码：" + verificationCode);

        return verificationCodeService.checkCode(passengerPhone, verificationCode);
    }
}
