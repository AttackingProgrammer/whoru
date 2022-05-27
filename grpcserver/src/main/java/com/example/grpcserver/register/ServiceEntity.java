package com.example.grpcserver.register;

import lombok.Builder;
import lombok.Data;

/**
 * 服务信息
 */
@Data
@Builder
public class ServiceEntity {
    /**
     * serviceId
     */
    private String serviceId = "DEFAULT-SERVICEID";
    /**
     * serviceName
     */
    private String serviceName = "DEFAULT-SERVICE";
    /**
     * host
     */
    private String host = "localhost";
    /**
     * port
     */
    private int port = 8080;
    /**
     * endpoint
     */
    private String endPoint = "localhost:8080";



    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }


}
