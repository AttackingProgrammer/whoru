package com.example.grpcserver.config;

import com.example.grpcserver.etcd.ServiceGovernanceClient;
import com.example.grpcserver.factory.GrpcServerFactory;
import com.example.grpcserver.factory.GrpcServerLifecycle;
import com.example.grpcserver.factory.IGrpcServerFactory;
import com.example.grpcserver.register.ServiceEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @ClassName GrpcAutoconfiguration
 * @Author ydp
 * @Version
 * @Date 2022/2/11
 */
@Configuration
public class GrpcAutoconfiguration {
    @Bean
    public GrpcServerConfig grpcServerConfig() {
        return new GrpcServerConfig();
    }
    /**
     * netty server
     *
     * @return
     */
    @Bean
    public IGrpcServerFactory grpcServerFactory(GrpcServerConfig grpcServerConfig) {
        final GrpcServerFactory factory = new GrpcServerFactory(grpcServerConfig);
        return factory;
    }

    /**
     * grpc server lifecycle
     *
     * @param factory
     * @return
     */
    @Bean
    public GrpcServerLifecycle grpcServerLifecycle(final IGrpcServerFactory factory, ServiceGovernanceClient serviceGovernanceClient) {
        return new GrpcServerLifecycle(factory, serviceGovernanceClient);
    }

    /**
     * 服务治理grpc
     *
     * @return
     */
    @Bean
    public ServiceGovernanceClient serviceGovernanceClient(IGrpcServerFactory factory, GrpcServerConfig grpcServerConfig,
                                                           GovernanceConfig governanceConfig) {
        String host = factory.getAddress();
        String endPoint = host + ":" + grpcServerConfig.getPort();
        //指定-Denv=dev
        String env = System.getProperty("env");
        return new ServiceGovernanceClient(governanceConfig.getEtcdEndpoints(), ServiceEntity.builder()
                .endPoint(endPoint)
                .host(host).port(grpcServerConfig.getPort()).serviceId(grpcServerConfig.getId())
                .serviceName(grpcServerConfig.getName()).build());
    }
}
