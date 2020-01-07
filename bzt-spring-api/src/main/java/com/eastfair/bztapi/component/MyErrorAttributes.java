package com.eastfair.bztapi.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

//3、给容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    //返回值的map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        //springboot默认返回的错误规则
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);

        //定制添加的字段
        map.put("company", "lhl");

        //异常处理器 额外带的字段
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        ext.put("path", map.get("path"));
        ext.put("company", "lxn");
        return ext;
    }
}
