package jmcunst.spring001.helloboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class HellobootApplication2 {
    public static void main(String[] args){
        // 4.1 스프링 컨테이너 사용
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        applicationContext.registerBean(HellobootApplication2.class);
        applicationContext.registerBean(SimpleHelloService2.class); // 4.4 의존 오브젝트 DI 적용
        applicationContext.refresh();

        // 3.2. 서블릿 컨테이너 띄우기
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(serverContext -> { // 3.3 Servlet 등록
            serverContext.addServlet("frontcontroller", new HttpServlet() { // 3.6 프론트 컨트롤러
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())){
                        String name = req.getParameter("name");

                        HelloController2 helloController2 = applicationContext.getBean(HelloController2.class);
                        String ret = helloController2.hello(name);

                        resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println(ret);
                    }else{
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }

                }
            }).addMapping("/hello");
        });
        webServer.start();
    }
}
