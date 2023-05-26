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
        registry.addHandler(buildTextHandler(), "/room")
                .addInterceptors(springBootHandshakeInterceptor())
                .setAllowedOrigins("*");
    }

    /**
     * 添加消息处理器
     * @return
     */
    @Bean
    public WebSocketHandler buildTextHandler() {
        return new TextHandler();
    }

    /**
     * 添加握手拦截
     * @return
     */
    @Bean
    public SpringBootHandshakeInterceptor springBootHandshakeInterceptor() {
        return new SpringBootHandshakeInterceptor();
    }
}