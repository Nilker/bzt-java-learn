package com.eastfair.bztapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "用户类")
public class User {

    @ApiModelProperty(value = "ID", example = "100")
    private Integer id;

    @ApiModelProperty(value = "姓名", example = "laolunsi")
    private String name;

    @ApiModelProperty(value = "是否启用", example = "1")
    private Boolean enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @ApiModelProperty("更新时间")
    private Date updateTime;

    public User(Integer id, String name, Boolean enable, Date updateTime) {
        this.id = id;
        this.name = name;
        this.enable = enable;
        this.updateTime = updateTime;
    }

    // ... ignore getter and setter methods
}