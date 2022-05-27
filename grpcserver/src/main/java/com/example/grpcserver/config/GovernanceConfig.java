package com.example.grpcserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties("goverance")
public class GovernanceConfig {

    /**
     * etcd地址,多个用逗号分隔
     */
    private String etcdEndpoints = "http://192.168.1.74:2379";

    /**
     * 开启debug模式(client指定解析)
     */
    private boolean clientDebugFlag = false;

    /**
     * 具体debug信息
     */
    private Map<String, List<String>> ClientDebugInfo = new HashMap<>();

    public String getEtcdEndpoints() {
        return etcdEndpoints;
    }

    public void setEtcdEndpoints(String etcdEndpoints) {
        this.etcdEndpoints = etcdEndpoints;
    }

    public boolean isClientDebugFlag() {
        return clientDebugFlag;
    }

    public void setClientDebugFlag(boolean clientDebugFlag) {
        this.clientDebugFlag = clientDebugFlag;
    }

    public Map<String, List<String>> getClientDebugInfo() {
        return ClientDebugInfo;
    }

    public void setClientDebugInfo(Map<String, List<String>> clientDebugInfo) {
        ClientDebugInfo = clientDebugInfo;
    }
}
