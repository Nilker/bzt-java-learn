package com.eastfair.bztapi.model;

import com.fasterxml.jackson.databind.util.ClassUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "响应对象")
public class JsonFlag<T> {
    @ApiModelProperty(value = "响应码", name = "code", required = true)
    private int code;

    @ApiModelProperty(value = "响应消息", name = "msg", required = true)
    private String msg;

    @ApiModelProperty(value = "响应数据", name = "data")
    private T data;


    /**
     *
     * @param ex
     */
    public JsonFlag(Exception ex){
        this.setCode(ResultCodeEnum.FAIL.val());
        this.setMsg(ex.getMessage());
    }

    /**
     *
     * @param data
     */
    public JsonFlag(T data){
        this.setCode(ResultCodeEnum.SUCCESS.val());
        //this.setMsg(ResultCodeEnum.SUCCESS.msg());
        this.setData(data);
    }

    /**
     *
     * @param codeEnum
     */
    public JsonFlag(ResultCodeEnum codeEnum) {
        this.setCode(codeEnum.val());
        this.setMsg(codeEnum.msg());
    }

    /**
     *
     * @param codeEnum
     * @param msg
     */
    public JsonFlag(ResultCodeEnum codeEnum,String msg){
        this.setCode(codeEnum.val());
        this.setMsg(msg);
    }

    /**
     *
     * @param codeEnum
     * @param msg
     * @param data
     */
    public JsonFlag(ResultCodeEnum codeEnum, String msg, T data) {
        this.setCode(codeEnum.val());
        this.setMsg(msg);
        this.setData(data);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
