package jmcunst.spring001.helloboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

@SpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {
        new TomcatServletWebServerFactory();
    }

}
