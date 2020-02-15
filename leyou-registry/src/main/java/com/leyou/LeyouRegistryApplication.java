package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author XuQiaoYang
 * @Date 2020/1/31 14:18
 */
@SpringBootApplication
@EnableEurekaServer
public class LeyouRegistryApplication {

    public static void main(String[] args) {//创建引导类
        SpringApplication.run(LeyouRegistryApplication.class, args);
    }
}
