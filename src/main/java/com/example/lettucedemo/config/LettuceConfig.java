package com.example.lettucedemo.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;


@Configuration
public class LettuceConfig {

    @Bean("genericObjectPoolConfiguration")
    @ConfigurationProperties(prefix="spring.redis.myconfig.lettuce.pool")
    public GenericObjectPoolConfig getGenericObjectPoolConfig() {
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        return genericObjectPoolConfig;
    }

    @Bean("redisStandaloneConfiguration")
    @ConfigurationProperties(prefix="spring.redis.myconfig")
    public RedisStandaloneConfiguration getRedisStandaloneConfiguration() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        return redisStandaloneConfiguration;
    }
}