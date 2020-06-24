package com.msr.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Fei
 * @Package com.msr.gateway
 * @date 2020/6/23 13:44
 *
 * gateway网关只对请求处理，不做数据库的处理，因此需要排除数据源的加载
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MsrGatwayApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsrGatwayApplication.class, args);
    }
}
