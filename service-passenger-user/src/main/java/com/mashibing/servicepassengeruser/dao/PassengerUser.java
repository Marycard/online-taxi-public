package com.mashibing.servicepassengeruser.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//数据库对应的类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerUser {


    private int userId;
    private String Name;
    private String Gender;
    private String Phone;
    private int Status;


}
