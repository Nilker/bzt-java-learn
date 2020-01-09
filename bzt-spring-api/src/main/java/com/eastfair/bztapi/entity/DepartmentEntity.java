package com.eastfair.bztapi.entity;

import com.eastfair.bztapi.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 
* </p>
*
* @author lhl
* @since 2020-01-09
*/
@Data
    @EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("department")
@ApiModel(value="DepartmentEntity对象", description="")
public class DepartmentEntity extends BaseEntity {

private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("departmentName")
    private String departmentName;


}
