package jmcunst.spring001.config;

import jmcunst.spring001.helloboot.CorsConfiguration;
import jmcunst.spring001.helloboot.SecurityConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration
@ComponentScan
@EnableMyAutoConfiguration
@Import({CorsConfiguration.class, SecurityConfig.class})
public @interface MySpringBootApplication {
}
