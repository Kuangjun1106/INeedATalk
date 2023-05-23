package com.kuangjun.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author KJ
 * @Date 2023/5/22 下午 2:30
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

    @GetMapping("hi")
    public String hi() {
        return "hi";
    }

    /**
     * 发送聊天
     */
    @Autowired
    private RabbitTemplate template;

    @GetMapping("say")
    public String sayHI(String msg) {
        String queueName = "simple.queue";
        template.convertAndSend(queueName, msg);
        return "OK";
    }
}
