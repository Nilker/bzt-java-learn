package com.eastfair.bztapi.config;

import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

@Component
public class MyWebConfig implements WebMvcConfigurer {

    /**
     * 路由
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/","/swagger-ui.html");
    }

    /**
     * 接受日期参数格式化  https://blog.csdn.net/weixin_38229356/article/details/81228923
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(
                new Formatter<Date>() {
                    @Override
                    public Date parse(String strDate, Locale locale) throws ParseException {
                        return new Date(Long.parseLong(strDate));
                    }

                    @Override
                    public String print(Date date, Locale locale) {
                        return Long.valueOf(date.getTime()).toString();
                    }
                }
        );
    }


}
