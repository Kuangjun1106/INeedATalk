package com.kuangjun.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author KJ
 * @Date 2023/5/24 上午 9:11
 */
@Component
public class RoomQueueConfig {

    @Bean
    public Queue chatQueue(){
        return new Queue("chat.queue");
    }
}
