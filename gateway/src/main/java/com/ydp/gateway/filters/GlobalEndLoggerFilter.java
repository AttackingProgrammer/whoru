package com.ydp.gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

/**
 */
@Component
@Slf4j
public class GlobalEndLoggerFilter implements GlobalFilter, Ordered {

    private void endLogInfo(ServerWebExchange exchange, long time) {
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().toString();
        String attribute = exchange.getRequiredAttribute(GATEWAY_REQUEST_URL_ATTR).toString();

        StringBuilder builder = new StringBuilder();
        builder.append("******请求路径:[{}]请求结束, 耗时:[{}]ms******\n");
        builder.append("gateway_request_url: " + attribute + "\n");
        log.info(String.valueOf(builder), url, time);
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //后置过滤
        Instant instant = (Instant) BaseContextHandler.getContextMap();
        if (instant != null) {
            endLogInfo(exchange, Duration.between(instant, Instant.now()).toMillis());
        } else {
            endLogInfo(exchange, 0L);
        }

        BaseContextHandler.remove();

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
}
