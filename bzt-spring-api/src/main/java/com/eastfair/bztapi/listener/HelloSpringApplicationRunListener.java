package com.eastfair.bztapi.listener;

import com.fasterxml.jackson.databind.util.ClassUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;


public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {

    public HelloSpringApplicationRunListener(SpringApplication application, String[] args){

    }


    @Override
    public void starting() {
        System.out.println("HelloSpringApplicationRunListener--->Starting--->执行了");
    }

    /**
     * 获取系统属性
     * @param environment
     */
    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        Map<String, Object> systemProperties =  environment.getSystemProperties();
        System.out.println("HelloSpringApplicationRunListener--->environmentPrepared--->"+systemProperties.toString());
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener--->contextPrepared");
    }

    /**
     * 加载完成
     * @param context
     */
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener--->contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener--->started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener--->running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("HelloSpringApplicationRunListener--->failed");
    }
}
