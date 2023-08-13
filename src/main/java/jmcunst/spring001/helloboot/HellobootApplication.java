package jmcunst.spring001.helloboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

@SpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            HelloController helloController = new HelloController();
            servletContext.addServlet("frontcontroller", new HttpServlet() { // 18. 프론트컨트롤러
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    // 인증, 보안, 다국어, 공통 기능
                    if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())){ // 20. 맵핑
                        String name = req.getParameter("name");

                        String ret = helloController.hello(name); // 20. 바인딩

                        resp.setStatus(HttpStatus.OK.value());
                        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println(ret);
                    }
                    else if (req.getRequestURI().equals("/user")) {

                    }
                    else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
            }).addMapping("/*"); // 18. 프론트컨트롤러
        }); // 웹 서버 생성 // 파라미터(ServletContextInitializer)를 통해 서블릿 등록 // Lambda식으로 servletContext로 사용
        webServer.start(); // 톰켓 서블릿 컨테이너가 동작
    }

}
