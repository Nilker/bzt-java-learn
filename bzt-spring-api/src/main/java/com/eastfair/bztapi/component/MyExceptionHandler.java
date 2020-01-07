package com.eastfair.bztapi.component;

import com.eastfair.bztapi.model.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理器
 */
@ControllerAdvice
public class MyExceptionHandler {
//1、 缺点没有自适应效果
//    @ResponseBody
//    @ExceptionHandler
//    public Map<String,Object> handleException(Exception ex){
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("put", ResultCodeEnum.FAIL);
//        map.put("msg",ex.getMessage());
//        return map;
//    }

    //2、 有自适应的 但是定制化 数据没有
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", ResultCodeEnum.FAIL.val());
        map.put("msg", e.getMessage());

        //将错误信息放入 请求域中
        request.setAttribute("ext", map);
        //转发到/error
        return "forward:/error";
    }
}
