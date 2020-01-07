package com.eastfair.bztapi.model;

public enum ResultCodeEnum {

    // 成功
    SUCCESS(200,"操作成功"),

    // 失败
    FAIL(400,"操作失败"),

    // 未认证（签名错误）
    UNAUTHORIZED(401,"未授权"),

    // 接口不存在
    NOT_FOUND(404,"不存在"),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500,"服务器错误");

    private int value = 0;
    private String message="";

    private ResultCodeEnum(int value,String msg) {     //必须是private的，否则编译错误
        this.value = value;
        this.message=msg;
    }

    public int val() {
        return this.value;
    }
    public String msg(){
        return this.message;
    }
}
