package jmcunst.spring001.helloboot;

import jmcunst.spring001.dto.MyRequestDto;
import jmcunst.spring001.dto.MyResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        if (name == null || name.trim().length() == 0) throw new IllegalArgumentException();

        return helloService.sayHello(name);
    }
    @GetMapping("/count")
    public String count(String name){
        return name + ":" + helloService.countOf(name);
    }

    @PostMapping("/bye")
    public MyResponseDto handleRequest(@RequestBody MyRequestDto request) {
        // 요청 바디(request)를 그대로 응답으로 반환
        MyResponseDto response = new MyResponseDto(request.getMessage());
        return response;
    }
}