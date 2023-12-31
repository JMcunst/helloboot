//package jmcunst.spring001.helloboot;
//
//import jakarta.annotation.PostConstruct;
//import jmcunst.spring001.config.MySpringBootApplication;
//import org.springframework.boot.SpringApplication;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//@MySpringBootApplication
//public class HellobootApplication3 {
//    private final JdbcTemplate jdbcTemplate;
//
//    public HellobootApplication3(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @PostConstruct
//    void init(){
//        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
//    }
//
//    public static void main(String[] args) {
//        // 28. GenericWebApplicationContext은 자바 코드로 만든 환경설정 정보를 읽을 수 없다.
//        SpringApplication.run(HellobootApplication3.class, args);
//    }
//}
