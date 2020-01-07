package com.eastfair.bztapi.controller;

import com.eastfair.bztapi.model.JsonFlag;
import com.eastfair.bztapi.model.ResultCodeEnum;
import com.eastfair.bztapi.service.IUserService;
import com.eastfair.bztapi.entity.UserEntity;
import com.siyuyou.customstarter.siyuyouspringbootstarterautoconfigurer.HelloService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.eastfair.bztapi.common.BaseController;


/**
* <p>
    * Users and global privileges 前端控制器
    * </p>
*
* @author lhl
* @since 2019-12-31
* @version v1.0
*/
@Api(tags = {"Users and global privileges"})
@RestController
@RequestMapping("/bztapi/user-entity")
public class UserController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    /**
    * 查询分页数据
    */
    @ApiOperation(value = "查询分页数据")
    @GetMapping(value = "/list")
    public JsonFlag<IPage<UserEntity>> findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,@RequestParam(name = "pageSize", defaultValue = "20") int pageSize){
        //TODO obj类型自行修改
        Page<UserEntity> pageParam = new Page<>(pageNum, pageSize); // 当前页码，每页条数
        IPage<UserEntity> models = userService.page(pageParam);
        return new JsonFlag<IPage<UserEntity>>(models);
     }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询数据")
    @GetMapping(value = "/getById")
    public JsonFlag<UserEntity> getById(@RequestParam("pkid") String pkid){
        UserEntity model = userService.getById(pkid);
        return new JsonFlag<UserEntity>(model);
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JsonFlag<UserEntity> save(@RequestBody UserEntity userEntity){
        // TODO obj类型自行修改
        boolean b =  userService.save(userEntity);
        return new JsonFlag(ResultCodeEnum.SUCCESS);
    }

    /**
    * 删除
    */
    @ApiOperation(value = "删除数据")
    @GetMapping(value = "/del")
    public JsonFlag delete(@RequestParam("ids") List<String> ids){
        boolean b = userService.removeByIds(ids);
        return new JsonFlag(ResultCodeEnum.SUCCESS);
    }

    /**
    * 修改
    */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JsonFlag<UserEntity> update(@RequestBody UserEntity userEntity){
        // TODO obj类型自行修改
        boolean b =  userService.updateById(userEntity);
        return new JsonFlag(ResultCodeEnum.SUCCESS);
    }

}
