package com.course;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.course.mapper"})
public class FrontApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrontApplication.class,args);
    }
}
