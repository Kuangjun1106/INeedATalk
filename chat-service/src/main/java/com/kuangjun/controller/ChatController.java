package com.kuangjun.controller;

import com.kuangjun.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author KJ
 * @Date 2023/5/22 下午 2:30
 */
@RestController
@RequestMapping("chat")
@Slf4j
public class ChatController {

    @Autowired
    private RabbitTemplate template;

    /**
     * 发送聊天信息
     *
     * @param msg 信息
     * @return
     */
    @PostMapping("send")
    public String sendMsg(@RequestBody Message msg) {
        log.info(msg.getNickName() + "发送了消息:" + msg.getContent());
        // 保存信息到数据库
        // 通知 room 发送通信
        String queueName = "chat.queue";
        template.convertAndSend(queueName, msg);
        return "OK";
    }
}
