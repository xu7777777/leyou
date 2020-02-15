package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author XuQiaoYang
 * @Date 2020/2/14 12:20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LeyouUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeyouUploadApplication.class);
    }

}
