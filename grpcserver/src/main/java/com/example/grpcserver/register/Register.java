package com.example.grpcserver.register;

public interface Register {
    /**
     * 服务注册
     */
    void register();

    /**
     * 服务重新注册
     */
    void reRegister();


    /**
     * 服务注销
     */
    void unRegister();

    /**
     * 服务续约(续约1次)
     */
    void keepAlive();

}
