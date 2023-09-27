package com.baidu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.baidu.mapper")
public class Springboot0915Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot0915Application.class, args);
    }

}
