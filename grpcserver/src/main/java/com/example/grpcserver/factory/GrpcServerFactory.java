package com.example.grpcserver.factory;

import com.example.grpcserver.config.GrpcServerConfig;
import com.example.grpcserver.serviceimpl.GreeterImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GrpcServerFactory<T extends ServerBuilder<T>> implements IGrpcServerFactory {
    private static final Logger log = LoggerFactory.getLogger(GrpcServerFactory.class);

    private final GrpcServerConfig config;

    public GrpcServerFactory(GrpcServerConfig config) {
        this.config = config;
    }

    @Override
    public Server createServer() {
        Server server = ServerBuilder.
                forPort(config.getPort())
                .addService(new GreeterImpl())
                .build();
        return server;
    }

    @Override
    public String getAddress() {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        if (inetAddress != null) {
            return StringUtils.substringAfterLast(inetAddress.toString(), "/");
        } else {
            return "";
        }
    }

    @Override
    public int getPort() {
        return this.config.getPort();
    }

    @Override
    public void destroy() {

    }


}
