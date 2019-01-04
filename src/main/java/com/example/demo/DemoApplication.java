package com.example.demo;

import com.example.demo.utils.JsonConverters;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wangyu
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * 指定fastJson序列化
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        return JsonConverters.fastJsonConverter();
    }
}

