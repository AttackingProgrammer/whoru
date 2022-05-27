package com.example.grpcserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import sun.misc.Launcher;

import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
@ServletComponentScan
public class GrpcserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrpcserverApplication.class, args);

    }

}
