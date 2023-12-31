//package jmcunst.spring001.helloboot;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.stream.IntStream;
//
//@HellobootTest
//public class HelloServiceCountTest3 {
//    @Autowired HelloService helloService;
//    @Autowired HelloRepository helloRepository;
//
//    @Test
//    void sayHelloIncreaseCount(){
//        IntStream.rangeClosed(1, 10).forEach(count -> {
//            helloService.sayHello("Jmcunst");
//            Assertions.assertThat(helloRepository.countOf("Jmcunst")).isEqualTo(count);
//        });
//    }
//}
