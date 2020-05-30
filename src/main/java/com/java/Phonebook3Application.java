package com.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.java.mapper")
public class Phonebook3Application {

    public static void main(String[] args) {
        SpringApplication.run(Phonebook3Application.class, args);
    }

}
