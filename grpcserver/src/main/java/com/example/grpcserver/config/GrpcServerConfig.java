package com.example.grpcserver.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("grpc.server")
public class GrpcServerConfig {

    /**
     * grpc 端口
     */
    private int port = 50051;

    /**
     * 服务ID
     */
    private String id = "DEFAULT-SERVICE-ID";


    /**
     * 服务名称
     */
    private String name = "DEFAULT-SERVICE-NAME";

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
