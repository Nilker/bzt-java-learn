package ${package.Controller};

import com.eastfair.bztapi.model.JsonFlag;
import com.eastfair.bztapi.model.ResultCodeEnum;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
* <p>
    * ${table.comment!} 前端控制器
    * </p>
*
* @author ${author}
* @since ${date}
* @version v1.0
*/
<#if restControllerStyle>
@Api(tags = {"${table.comment!}"})
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};

    /**
    * 查询分页数据
    */
    @ApiOperation(value = "查询分页数据")
    @GetMapping(value = "/list")
    public JsonFlag<IPage<${entity}>> findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,@RequestParam(name = "pageSize", defaultValue = "20") int pageSize){
        //TODO obj类型自行修改
        Page<${entity}> pageParam = new Page<>(pageNum, pageSize); // 当前页码，每页条数
        IPage<${entity}> models = ${(table.serviceName?substring(1))?uncap_first}.page(pageParam);
        return new JsonFlag<IPage<${entity}>>(models);
     }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询数据")
    @GetMapping(value = "/getById")
    public JsonFlag<${entity}> getById(@RequestParam("pkid") String pkid){
        ${entity} model = ${(table.serviceName?substring(1))?uncap_first}.getById(pkid);
        return new JsonFlag<${entity}>(model);
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JsonFlag<${entity}> save(@RequestBody ${entity} ${entity?uncap_first}){
        // TODO obj类型自行修改
        boolean b =  ${(table.serviceName?substring(1))?uncap_first}.save(${entity?uncap_first});
        return new JsonFlag(ResultCodeEnum.SUCCESS);
    }

    /**
    * 删除
    */
    @ApiOperation(value = "删除数据")
    @GetMapping(value = "/del")
    public JsonFlag delete(@RequestParam("ids") List<String> ids){
        boolean b = ${(table.serviceName?substring(1))?uncap_first}.removeByIds(ids);
        return new JsonFlag(ResultCodeEnum.SUCCESS);
    }

    /**
    * 修改
    */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JsonFlag<${entity}> update(@RequestBody ${entity} ${entity?uncap_first}){
        // TODO obj类型自行修改
        boolean b =  ${(table.serviceName?substring(1))?uncap_first}.updateById(${entity?uncap_first});
        return new JsonFlag(ResultCodeEnum.SUCCESS);
    }

}
</#if>