package com.zwl.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zwl.learn.dao")
public class LearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

}
