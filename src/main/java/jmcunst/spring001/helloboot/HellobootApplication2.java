package jmcunst.spring001.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration // 4.8 자바 코드 구성 정보 사용
public class HellobootApplication2 {
    @Bean // 4.8 자바 코드 구성 정보 사용
    public HelloController2 helloController2(HelloService helloService){ // 4.8 팩토리 메소드, 해당 메소드를 통해 해당 타입의 빈 오브젝트가 생성
        return new HelloController2(helloService);
    }
    @Bean
    public HelloService helloService(){ // 4.8 팩토리 메소드, 해당 메소드를 통해 해당 타입의 빈 오브젝트가 생성
        return new SimpleHelloService();
    }
    public static void main(String[] args){
        // 4.1 스프링 컨테이너 사용
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() { // 4.7. 스프링 컨테이너가 생성될때 서블릿 컨테이너도 생성되게끔
            @Override
            protected void onRefresh() {
                super.onRefresh();

                // 3.2. 서블릿 컨테이너 띄우기
                ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
                WebServer webServer = serverFactory.getWebServer(serverContext -> { // 3.3 Servlet 등록
                    serverContext.addServlet("dispatcherServlet", new DispatcherServlet(this) // 4.5 DispatcherServlet 전환
                    ).addMapping("/*");
                });
                webServer.start();

            }
        };
        applicationContext.register(HellobootApplication2.class);
        applicationContext.refresh();
    }
}
