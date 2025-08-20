package com.mashibing.servicepassengeruser.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.servicepassengeruser.dao.PassengerUser;
import com.mashibing.servicepassengeruser.mapper.PassengerUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private PassengerUserMapper PassengerUserMapper;
    public ResponseResult loginOrRegsiter(String passengerPhone) {

        System.out.println("调用service");
        //根据手机号查询用户信息
        //  1. 使用mybatis连接数据库:yml文件
        //  2.代码
        Map<String, Object> map= new HashMap<>();
        map.put("phone",passengerPhone);
        List<PassengerUser> passengerUsers = PassengerUserMapper.selectByMap(map);
        System.out.println(passengerUsers);


        //查询用户是否存在
        System.out.println("merge test");

        //不存在，插入用户信息
        return ResponseResult.success("");
    }
}
