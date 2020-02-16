package com.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author XuQiaoYang
 * @Date 2020/2/13 14:40
 */

@Configuration
public class LeyouCorsConfigration {

    @Bean
    public CorsFilter corsFilter(){

        //初始化配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许跨域的域名，如果要携带cookies，不能写*，*代表所有域名都可以跨域访问。
        corsConfiguration.addAllowedOrigin("http://manage.leyou.com");
        corsConfiguration.addAllowedOrigin("http://www.leyou.com");
        corsConfiguration.setAllowCredentials(true);//允许携带cookie
        corsConfiguration.addAllowedMethod("*");//允许所有方法跨域
        corsConfiguration.addAllowedHeader("*");//允许携带任何请求头

        //初始化cors配置源对象
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        System.out.println("++++++++++++++++++++");

        //返回corsFilter实例，参数：cors配置源对象。
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
