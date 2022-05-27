package com.ydp.gateway.resilience4j;


import com.alibaba.fastjson.JSONObject;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.filter.factory.FallbackHeadersGatewayFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @ClassName ReactiveResilience4JCircuitBreaker
 * @Author ydp
 * @Version
 * @Date 2021/11/25
 */
@Configuration
public class ReactiveResilience4JCircuitBreaker {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /*@Bean
    public KeyResolver userKeyResolver() {
        return exchange -> {
            return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
        };
    }*/
    @Bean
    public FallbackHeadersGatewayFilterFactory defalutFallback() {
        return new FallbackHeadersGatewayFilterFactory();
    }
    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defalutCustomizer(CircuitBreakerRegistry circuitBreakerRegistry) {
        CircuitBreakerConfig config = circuitBreakerRegistry.getConfiguration("myConfig").get();
        logger.info("!!!!!!!!!!!!!!!!!!configsss={}", JSONObject.toJSONString(config));
        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(circuitBreakerRegistry.getConfiguration("myConfig").get())
                .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(10)).build())
                .build());
    }
}
