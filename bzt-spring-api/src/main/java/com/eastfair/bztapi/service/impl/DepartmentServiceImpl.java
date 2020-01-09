package com.eastfair.bztapi.service.impl;

import com.eastfair.bztapi.entity.DepartmentEntity;
import com.eastfair.bztapi.mapper.mysql.DepartmentDao;
import com.eastfair.bztapi.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* <p>
    *  服务实现类
    * </p>
*
* @author lhl
* @since 2020-01-09
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDao, DepartmentEntity> implements IDepartmentService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DepartmentDao mapper;

}
