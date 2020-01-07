package com.eastfair.bztapi.service.impl;

import com.eastfair.bztapi.entity.AppPushInfoEntity;
import com.eastfair.bztapi.mapper.sqlserver.AppPushInfoDao;
import com.eastfair.bztapi.service.IAppPushInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* <p>
    * 消息推送 服务实现类
    * </p>
*
* @author lhl
* @since 2019-12-31
*/
@Service
public class AppPushInfoServiceImpl extends ServiceImpl<AppPushInfoDao, AppPushInfoEntity> implements IAppPushInfoService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AppPushInfoDao mapper;

}
