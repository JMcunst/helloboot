package jmcunst.spring001.helloboot;

import java.util.Objects;

public class HelloController2 {
    private final HelloService helloService2;

    public HelloController2(HelloService helloService){
        this.helloService2 = helloService;
    }
    public String hello(String name){
        return helloService2.sayHello(Objects.requireNonNull(name));
    }
}
