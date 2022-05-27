package com.example.grpcserver.serviceimpl;

import com.example.helloworld.GreeterGrpc;
import com.example.helloworld.HelloReply;
import com.example.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @ClassName GreeterImpl
 * @Author ydp
 * @Version
 * @Date 2022/2/10
 */
@GrpcService
public class GreeterImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver){
        HelloReply reply = HelloReply.newBuilder().setMessage(("Hello "+req.getName())).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
        System.out.println("Message from gRPC-Client:" + req.getName());
    }
}