package jmcunst.spring001.helloboot;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @CrossOrigin
    @GetMapping("/hello")
    @ResponseBody // 응답을 JSON으로 변환
    public String hello(@RequestParam String name) {
        if (name == null || name.trim().length() == 0) throw new IllegalArgumentException();

        return "{\"message\": \"" + helloService.sayHello(name) + "\"}";
    }
}