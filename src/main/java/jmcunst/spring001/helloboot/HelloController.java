package jmcunst.spring001.helloboot;

import java.util.Objects;

public class HelloController {
    public String hello(String name){
        SimpleHelloService helloService = new SimpleHelloService();

        return helloService.sayHello(Objects.requireNonNull(name));
    }
}