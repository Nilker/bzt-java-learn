package com.siyuyou.customstarter.siyuyouspringbootstarterautoconfigurer;

public class HelloService {
    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello(){
        String s = helloProperties.toString();
        return s;
    }
}
