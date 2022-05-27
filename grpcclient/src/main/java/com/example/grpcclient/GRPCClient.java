package com.example.grpcclient;

import com.example.helloworld.GreeterGrpc;
import com.example.helloworld.HelloReply;
import com.example.helloworld.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author: guangxush
 * @create: 2019/07/07
 */
public class GRPCClient {
    private static final String host = "127.0.0.1";
    private static final int serverPort = 9944;

    public static void main( String[] args ) throws Exception {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress( host, serverPort ).usePlaintext().build();
        try {
            GreeterGrpc.GreeterBlockingStub rpcDateService = GreeterGrpc.newBlockingStub( managedChannel );
            HelloRequest rpcDateRequest = HelloRequest
                    .newBuilder()
                    .setName("shgx")
                    .build();
            HelloReply rpcDateResponse = rpcDateService.sayHello( rpcDateRequest );
            System.out.println( rpcDateResponse.getMessage() );
        } finally {
            managedChannel.shutdown();
        }
    }
}
