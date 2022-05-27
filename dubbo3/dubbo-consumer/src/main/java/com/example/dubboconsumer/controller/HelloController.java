package com.example.dubboconsumer.controller;

import com.example.proto.DemoService;
import com.example.proto.HelloReply;
import com.example.proto.HelloRequest;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Author ydp
 * @Version
 * @Date 2022/2/15
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @DubboReference(id = "demoService", version = "1.0.0")
    private DemoService demoService;


    @PostMapping("/test")
    public String sayHello(@RequestBody String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply helloReply = demoService.sayHello(request);
        System.out.println(helloReply.getMessage());

        return helloReply.getMessage();
    }
}
