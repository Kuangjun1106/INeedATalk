package com.kuangjun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
public class SpringWebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //添加通信地址路径
        registry.addHandler(buildTextHandler(), "/room").setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler buildTextHandler() {
        //添加消息处理器
        return new TextHandler();
    }

}