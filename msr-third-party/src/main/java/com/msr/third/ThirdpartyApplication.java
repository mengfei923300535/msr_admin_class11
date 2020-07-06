package com.msr.third;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Fei
 * @Package com.msr.third
 * @date 2020/7/1 16:58
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ThirdpartyApplication {
    public static void main(String[] args){
        SpringApplication.run(ThirdpartyApplication.class,args);
    }
}
