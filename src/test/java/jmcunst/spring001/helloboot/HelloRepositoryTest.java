package jmcunst.spring001.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired HelloRepository helloRepository;

    @Test
    void findHelloFailed(){
        Assertions.assertThat(helloRepository.findHello("Jmcunst")).isNull();
    }

    @Test
    void increaseCount(){
        Assertions.assertThat(helloRepository.countOf("Jmcunst")).isEqualTo(0);

        helloRepository.increaseCount("Jmcunst");
        Assertions.assertThat(helloRepository.countOf("Jmcunst")).isEqualTo(1);

        helloRepository.increaseCount("Jmcunst");
        Assertions.assertThat(helloRepository.countOf("Jmcunst")).isEqualTo(2);
    }
}
