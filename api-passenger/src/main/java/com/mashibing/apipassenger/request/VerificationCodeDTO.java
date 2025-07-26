package com.mashibing.apipassenger.request;

public class VerificationCodeDTO {

    private String passengerPhone;


    //右击generate，自动生成
    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }
}
