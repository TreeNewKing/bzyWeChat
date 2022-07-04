package com.TreeNewKing.bzyWechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableTransactionManagement
public class BzyWechatRunApplication {

  public static void main(String[] args) {
    SpringApplication.run(BzyWechatRunApplication.class, args);
  }


  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public CorsFilter corsFilter() {
    //1. 添加 CORS配置信息
    CorsConfiguration config = new CorsConfiguration();
    //放行哪些原始域
    config.addAllowedOrigin("*");
    //是否发送 Cookie
    config.setAllowCredentials(true);
    //放行哪些请求方式
    config.addAllowedMethod("*");
    //放行哪些原始请求头部信息
    config.addAllowedHeader("*");
    //暴露哪些头部信息
    config.addExposedHeader("*");
    //2. 添加映射路径
    UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
    corsConfigurationSource.registerCorsConfiguration("/**", config);
    //3. 返回新的CorsFilter
    return new CorsFilter(corsConfigurationSource);

  }
}
