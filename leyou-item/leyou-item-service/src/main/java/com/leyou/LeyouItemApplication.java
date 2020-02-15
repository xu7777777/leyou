package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author XuQiaoYang
 * @Date 2020/1/31 18:14
 */
@MapperScan("com.leyou.item.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class LeyouItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeyouItemApplication.class, args);
    }
}
