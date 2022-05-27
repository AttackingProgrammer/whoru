
package com.example.grpcserver.factory;

import io.grpc.Server;
import org.springframework.beans.factory.DisposableBean;

public interface IGrpcServerFactory extends DisposableBean {

    Server createServer();

    String getAddress();

    int getPort();

    @Override
    void destroy();

}
