//package jmcunst.spring001.helloboot;
//
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Service;
//
//@Service
//@Primary // 5.3 HelloController required a single bean, but 2 were found 해결
//public class HelloDecorator3 implements HelloService{
//    private final HelloService helloService;
//
//    public HelloDecorator3(HelloService helloService) {
//        this.helloService = helloService;
//    }
//
//    @Override
//    public String sayHello(String name) {
//        return "*" + helloService.sayHello(name) + "*";
//    }
//
//    @Override
//    public int countOf(String name) {
//        return helloService.countOf(name);
//    }
//}
