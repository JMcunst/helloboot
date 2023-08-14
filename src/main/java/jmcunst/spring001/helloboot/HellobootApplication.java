package jmcunst.spring001.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// 스프링 컨테이너가 팩토리 메소드를 가진 클래스다라는 것을 인지하도록 함
@Configuration
public class HellobootApplication {
    // 28. 팩토리 메소드 사용.
    @Bean // 28. 스프링 컨테이너에게 알려준다.
    public HelloController helloController(HelloService helloService) {
        return new HelloController(helloService);
    }

    // 28. 팩토리 메소드 사용.
    @Bean // 28. 스프링 컨테이너에게 알려준다.
    public HelloService helloService() { // 28. 인터페이스 타입으로 리턴하기
        return new SimpleHelloService();
    }

    public static void main(String[] args) {
        // 28. GenericWebApplicationContext은 자바 코드로 만든 환경설정 정보를 읽을 수 없다.
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();
                ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet", new DispatcherServlet(this)
                    ).addMapping("/*"); // 18. 프론트컨트롤러
                }); // 웹 서버 생성 // 파라미터(ServletContextInitializer)를 통해 서블릿 등록 // Lambda식으로 servletContext로 사용
                webServer.start(); // 톰켓 서블릿 컨테이너가 동작
            }
        };
        applicationContext.register(HellobootApplication.class);
        applicationContext.refresh();
    }

}
