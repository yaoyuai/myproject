package com.course;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.course.mapper"})
public class BackAppliaction {

    public static void main(String[] args) {
        SpringApplication.run(BackAppliaction.class,args);
    }
}
