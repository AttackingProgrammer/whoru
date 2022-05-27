package com.ydp.shardingserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ydp.shardingserver.dao")
@ServletComponentScan
public class ShardingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingServerApplication.class, args);
    }

}
