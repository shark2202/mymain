package com.bytebroad.piping;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    
    @Bean
    public Employee employee(){
        return new Employee("myname");
    }
}
