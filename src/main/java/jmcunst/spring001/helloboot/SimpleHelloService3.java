//package jmcunst.spring001.helloboot;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class SimpleHelloService3 implements HelloService {
//    private final HelloRepository helloRepository;
//
//    public SimpleHelloService3(HelloRepository helloRepository) {
//        this.helloRepository = helloRepository;
//    }
//
//    @Override
//    public String sayHello(String name){
//        this.helloRepository.increaseCount(name);
//
//        return "Hello " + name;
//    }
//
//    @Override
//    public int countOf(String name) {
//        return helloRepository.countOf(name);
//    }
//}
