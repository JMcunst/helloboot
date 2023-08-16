package jmcunst.spring001.helloboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import java.io.IOException;

public class HellobootApplication2 {
    public static void main(String[] args){
        // 3.2. 서블릿 컨테이너 띄우기
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(serverContext -> { // 3.3 Servlet 등록
            serverContext.addServlet("hello", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    resp.setStatus(200);
                    resp.setContentType("text/plain");
                    resp.getWriter().println("Hello Servlet");
                }
            });
        });
        webServer.start();
    }
}
