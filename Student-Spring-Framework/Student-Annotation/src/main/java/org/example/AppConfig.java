package org.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "org.example")

public class AppConfig {

    @Bean
    public Address address(){
        return new Address("Houston","Texas","Harris","77001");
    }

    @Bean
    public Student student(){
        return new Student(1,"Jane Doe",ph() ,address());
    }
    @Bean
    public List<Phone> ph(){
        return Arrays.asList(new Phone("9998887"),new Phone("1112223"));
    }

}
