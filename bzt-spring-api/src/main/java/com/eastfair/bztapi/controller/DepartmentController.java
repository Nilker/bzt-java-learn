package com.eastfair.bztapi.controller;

import com.eastfair.bztapi.model.JsonFlag;
import com.eastfair.bztapi.model.ResultCodeEnum;
import com.eastfair.bztapi.service.IDepartmentService;
import com.eastfair.bztapi.entity.DepartmentEntity;
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
    *  前端控制器
    * </p>
*
* @author lhl
* @since 2020-01-09
* @version v1.0
*/
@Api(tags = {""})
@RestController
@RequestMapping("/bztapi/department-entity")
public class DepartmentController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IDepartmentService departmentService;

    /**
    * 查询分页数据
    */
    @ApiOperation(value = "查询分页数据")
    @GetMapping(value = "/list")
    public JsonFlag<IPage<DepartmentEntity>> findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,@RequestParam(name = "pageSize", defaultValue = "20") int pageSize){
        //TODO obj类型自行修改
        Page<DepartmentEntity> pageParam = new Page<>(pageNum, pageSize); // 当前页码，每页条数
        IPage<DepartmentEntity> models = departmentService.page(pageParam);
        return new JsonFlag<IPage<DepartmentEntity>>(models);
     }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询数据")
    @GetMapping(value = "/getById")
    @Cacheable(value = "depart",key = "#pkid")
    public JsonFlag<DepartmentEntity> getById(@RequestParam("pkid") String pkid){
        DepartmentEntity model = departmentService.getById(pkid);
        return new JsonFlag<DepartmentEntity>(model);
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JsonFlag<DepartmentEntity> save(@RequestBody DepartmentEntity departmentEntity){
        // TODO obj类型自行修改
        boolean b =  departmentService.save(departmentEntity);
        return new JsonFlag(ResultCodeEnum.SUCCESS);
    }

    /**
    * 删除
    */
    @ApiOperation(value = "删除数据")
    @GetMapping(value = "/del")
    @CacheEvict(value = "depart",key = "#ids.")
    public JsonFlag delete(@RequestParam("ids") List<String> ids){
        boolean b = departmentService.removeByIds(ids);
        return new JsonFlag(ResultCodeEnum.SUCCESS);
    }

    /**
    * 修改
    */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @CachePut(value = "depart",key = "#departmentEntity.id")
    public JsonFlag<DepartmentEntity> update(@RequestBody DepartmentEntity departmentEntity){
        // TODO obj类型自行修改
        boolean b =  departmentService.updateById(departmentEntity);
        return new JsonFlag(departmentEntity);
    }

}
