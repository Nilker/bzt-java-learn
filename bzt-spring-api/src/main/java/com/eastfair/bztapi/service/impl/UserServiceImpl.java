package com.eastfair.bztapi.service.impl;

import com.eastfair.bztapi.entity.UserEntity;
import com.eastfair.bztapi.mapper.mysql.UserDao;
import com.eastfair.bztapi.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* <p>
    * Users and global privileges 服务实现类
    * </p>
*
* @author lhl
* @since 2019-12-31
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements IUserService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao mapper;

}
