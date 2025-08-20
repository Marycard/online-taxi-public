package com.mashibing.servicepassengeruser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashibing.servicepassengeruser.dao.PassengerUser;
import org.springframework.stereotype.Repository;

//操作数据库的类，为什么是接口类？为什么还有一个@Repository注解？启动类加一个注解？怎么使用？
@Repository
public interface PassengerUserMapper extends BaseMapper<PassengerUser> {
}
