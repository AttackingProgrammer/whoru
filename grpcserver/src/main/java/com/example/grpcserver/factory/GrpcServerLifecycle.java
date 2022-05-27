package com.example.grpcserver.factory;

import com.example.grpcserver.etcd.ServiceGovernanceClient;
import io.grpc.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @ClassName SmartLifecycle
 * @Author ydp
 * @Version
 * @Date 2022/2/11
 */
public class GrpcServerLifecycle implements org.springframework.context.SmartLifecycle {
    private static final Logger logger = LoggerFactory.getLogger(GrpcServerLifecycle.class);

    private volatile Server server;

    private final IGrpcServerFactory factory;
    /**
     * 处理服务治理相关
     */
    private final ServiceGovernanceClient serviceGovernanceClient;

    public GrpcServerLifecycle(IGrpcServerFactory factory, ServiceGovernanceClient serviceGovernanceClient) {
        this.factory = factory;
        this.serviceGovernanceClient = serviceGovernanceClient;
    }


    @Override
    public void start() {
        this.server = factory.createServer();

        try {
            this.server.start();

            System.out.println( "grpc服务端启动成功, 端口=" + factory.getPort() );
            serviceGovernanceClient.start();
            // Prevent the JVM from shutting down while the server is running
            final Thread awaitThread = new Thread(() -> {
                try {
                    this.server.awaitTermination();
                } catch (final InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "grpc-server-container");
            awaitThread.setDaemon(false);
            awaitThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void stop() {
        final Server localServer = this.server;
        if (localServer != null) {
            localServer.shutdown();
            this.server = null;
            logger.info("gRPC server shutdown.");
        }
    }

    @Override
    public boolean isRunning() {
        return this.server != null && !this.server.isShutdown();
    }
}
