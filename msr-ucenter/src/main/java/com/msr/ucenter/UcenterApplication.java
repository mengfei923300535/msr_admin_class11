package com.msr.ucenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Fei
 * @Package com.msr.ucenter
 * @date 2020/6/15 14:33
 */
@MapperScan("com.msr.ucenter.mapper")
@SpringBootApplication
@ComponentScan(basePackages={"com.msr.ucenter","com.msr.common"})
public class UcenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UcenterApplication.class,args);
    }
}
