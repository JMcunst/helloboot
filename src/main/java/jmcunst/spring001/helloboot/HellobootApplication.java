package jmcunst.spring001.helloboot;

import jmcunst.spring001.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {
        // 28. GenericWebApplicationContext은 자바 코드로 만든 환경설정 정보를 읽을 수 없다.
        SpringApplication.run(HellobootApplication.class, args);
    }

}
