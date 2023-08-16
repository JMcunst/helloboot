package jmcunst.spring001.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HellobootApplication2 {
    public static void main(String[] args){
        // 4.1 스프링 컨테이너 사용
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext() { // 4.7. 스프링 컨테이너가 생성될때 서블릿 컨테이너도 생성되게끔
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
        applicationContext.registerBean(HellobootApplication2.class);
        applicationContext.registerBean(SimpleHelloService2.class); // 4.4 의존 오브젝트 DI 적용
        applicationContext.refresh();
    }
}
