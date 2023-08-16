package jmcunst.spring001.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@RequestMapping("/hello")
public class HelloController2 {
    private final HelloService helloService2;

    public HelloController2(HelloService helloService){
        this.helloService2 = helloService;
    }

    @GetMapping
    @ResponseBody
    public String hello(String name){
        return helloService2.sayHello(Objects.requireNonNull(name));
    }
}
