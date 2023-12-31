//package jmcunst.spring001.helloboot;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//@HellobootTest
//public class HelloRepositoryTest3 {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//    @Autowired HelloRepository helloRepository;
//
////    @BeforeEach
////    void init(){
////        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
////    }
//
//    @Test
//    void findHelloFailed(){
//        Assertions.assertThat(helloRepository.findHello("Jmcunst")).isNull();
//    }
//
//    @Test
//    void increaseCount(){
//        Assertions.assertThat(helloRepository.countOf("Jmcunst")).isEqualTo(0);
//
//        helloRepository.increaseCount("Jmcunst");
//        Assertions.assertThat(helloRepository.countOf("Jmcunst")).isEqualTo(1);
//
//        helloRepository.increaseCount("Jmcunst");
//        Assertions.assertThat(helloRepository.countOf("Jmcunst")).isEqualTo(2);
//    }
//}
