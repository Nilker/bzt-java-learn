package com.eastfair.bztapi.controller;

import com.eastfair.bztapi.model.JsonFlag;
import com.eastfair.bztapi.model.ResultCodeEnum;
import com.eastfair.bztapi.service.IAppPushInfoService;
import com.eastfair.bztapi.entity.AppPushInfoEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    * 消息推送 前端控制器
    * </p>
*
* @author lhl
* @since 2019-12-31
* @version v1.0
*/
@Api(tags = {"消息推送"})
@RestController
@RequestMapping("/bztapi/app-push-info-entity")
public class AppPushInfoController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IAppPushInfoService appPushInfoService;

    /**
    * 查询分页数据
    */
    @ApiOperation(value = "查询分页数据")
    @GetMapping(value = "/list")
    public JsonFlag<IPage<AppPushInfoEntity>> findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,@RequestParam(name = "pageSize", defaultValue = "20") int pageSize){
        //TODO obj类型自行修改
        Page<AppPushInfoEntity> pageParam = new Page<>(pageNum, pageSize); // 当前页码，每页条数
        IPage<AppPushInfoEntity> models = appPushInfoService.page(pageParam);
        return new JsonFlag<IPage<AppPushInfoEntity>>(models);
     }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询数据")
    @GetMapping(value = "/getById")
    @Cacheable(value = "appPush",key = "#pkid")
    public JsonFlag<AppPushInfoEntity> getById(@RequestParam("pkid") String pkid){
        AppPushInfoEntity model = appPushInfoService.getById(pkid);
        return new JsonFlag<AppPushInfoEntity>(model);
    }

    /**
     * 删除一个缓存
     *
     * @param userId
     * @return
     */
    @ApiOperation(value = "删除缓存")
    @GetMapping(value = "/delete-appPush")
    @CacheEvict("appPush")
    public String deleteUser(@RequestParam(required = true) String userId) {
        return "删除成功";
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JsonFlag<AppPushInfoEntity> save(@RequestBody AppPushInfoEntity appPushInfoEntity){
        // TODO obj类型自行修改
        boolean b =  appPushInfoService.save(appPushInfoEntity);
        return new JsonFlag(ResultCodeEnum.SUCCESS);
    }

    /**
    * 删除
    */
    @ApiOperation(value = "删除数据")
    @GetMapping(value = "/del")
    public JsonFlag delete(@RequestParam("ids") List<String> ids){
        boolean b = appPushInfoService.removeByIds(ids);
        return new JsonFlag(ResultCodeEnum.SUCCESS);
    }

    /**
    * 修改
    */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JsonFlag<AppPushInfoEntity> update(@RequestBody AppPushInfoEntity appPushInfoEntity){
        // TODO obj类型自行修改
        boolean b =  appPushInfoService.updateById(appPushInfoEntity);
        return new JsonFlag(ResultCodeEnum.SUCCESS);
    }

}
