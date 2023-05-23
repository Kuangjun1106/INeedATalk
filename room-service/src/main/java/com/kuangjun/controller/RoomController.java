package com.kuangjun.controller;

import com.kuangjun.config.SessionManager;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;

import java.io.IOException;

/**
 * @Author KJ
 * @Date 2023/5/22 下午 2:04
 */

@Controller
@RequestMapping("/room")
@Slf4j
public class RoomController {

    /**
     * todo: 查找聊天室、进入聊天室、显示聊天
     */
    @GetMapping("hi")
    public String hi() {
        return "hi";
    }

    /**
     * 向 session 发送 msg 信息
     *
     * @param session
     * @param msg
     */
    @GetMapping("{session}/send")
    public void send(@PathVariable("session") String session, String msg) {
        log.info("我接受到了实时通信请求：" + msg);
        WebSocketMessage webSocketMessage = new TextMessage(msg);
        try {
            SessionManager.get(session).sendMessage(webSocketMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
