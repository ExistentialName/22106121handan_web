package com.example.tust;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.tust.dao")
public class LwsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(LwsysApplication.class, args);
    }

}
