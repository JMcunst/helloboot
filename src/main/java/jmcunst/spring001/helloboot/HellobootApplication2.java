package jmcunst.spring001.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration // 4.8 자바 코드 구성 정보 사용
@ComponentScan // 4.9 Component 스캔
public class HellobootApplication2 {
    @Bean
    public ServletWebServerFactory servletWebServerFactory() { // 4.10 Bean의 생명주기 메소드
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet(){ // 4.10 Bean의 생명주기 메소드
        return new DispatcherServlet();
    }

//    public static void main(String[] args){
//        // 4.1 스프링 컨테이너 사용
//        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() { // 4.7. 스프링 컨테이너가 생성될때 서블릿 컨테이너도 생성되게끔
//            @Override
//            protected void onRefresh() {
//                super.onRefresh();
//
//                // 3.2. 서블릿 컨테이너 띄우기
//                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class); // 4.10 Bean의 생명주기 메소드
//                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class); // 4.10 Bean의 생명주기 메소드
//                dispatcherServlet.setApplicationContext(this); // 4.10 Bean의 생명주기 메소드
//
//                WebServer webServer = serverFactory.getWebServer(serverContext -> { // 3.3 Servlet 등록
//                    serverContext.addServlet("dispatcherServlet", dispatcherServlet // 4.5 DispatcherServlet 전환 // 4.10 Bean의 생명주기 메소드
//                    ).addMapping("/*");
//                });
//                webServer.start();
//
//            }
//        };
//        applicationContext.register(HellobootApplication2.class);
//        applicationContext.refresh();
//    }
}
