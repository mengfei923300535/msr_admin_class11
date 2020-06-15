package com.msr.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fei
 * @Package com.msr.edu
 * @date 2020/6/12 11:59
 */

//主类，启动类
    @SpringBootApplication
    @MapperScan("com.msr.edu.mapper")
    @ComponentScan(basePackages={"com.msr.edu","com.msr.common"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}

