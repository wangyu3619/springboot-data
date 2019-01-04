package com.example.demo.beans.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.example.demo.handler.MybatisMetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangyu
 * @date 2018/12/14 14:17
 */
@EnableTransactionManagement
@Configuration
@Slf4j
@ConditionalOnProperty(value = "spring.datasource.url")
public class MybatisPlusConfig {


    public MybatisPlusConfig(){
        log.debug("Mybatis plus config 已加载...");
    }
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {

        return new PaginationInterceptor();
    }

    @Bean
    public LogicSqlInjector logicSqlInjector() {

        return new LogicSqlInjector();
    }

    @Bean
    public MetaObjectHandler metaObjectHandler() {

        return new MybatisMetaObjectHandler();
    }
}