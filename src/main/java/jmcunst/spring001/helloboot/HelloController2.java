package jmcunst.spring001.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


//@Component // 4.9 Component 스캔
//@RequestMapping("/hello") // 4.9 Component 스캔
@RestController // 4.9 Component 스캔
public class HelloController2 {
    private final HelloService helloService2;

    public HelloController2(HelloService helloService){
        this.helloService2 = helloService;
    }


//    @ResponseBody // 4.9 Component 스캔
    @GetMapping("/hello")
    public String hello(String name){
        return helloService2.sayHello(Objects.requireNonNull(name));
    }
}
