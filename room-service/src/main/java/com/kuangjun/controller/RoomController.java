package com.kuangjun.controller;

import com.alibaba.fastjson.JSON;
import com.kuangjun.config.SessionManager;
import com.kuangjun.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author KJ
 * @Date 2023/5/22 下午 2:04
 */

@RestController
@RequestMapping("/room")
@Slf4j
public class RoomController {

    private static final Map<String, Set<String>> users = new HashMap<>();

    /**
     * 删除房间中的用户
     *
     * @param roomName
     * @param sessionID
     */
    public static void removeUser(String roomName, String sessionID) {
        users.get(roomName).remove(sessionID);
    }

    public static HttpSession getHttpSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return request.getSession();
    }

    /**
     * 用户进入房间
     * @param roomName
     * @return
     */
    @GetMapping("enterRoom")
    public String enterRoom(String roomName) {
        HttpSession httpSession = getHttpSession();
        httpSession.setAttribute("roomName", roomName);

        Set<String> set = users.get(roomName);
        if (set == null) {
            set = new HashSet<>();
            set.add(httpSession.getId());
            users.put(roomName, set);
        } else {
            set.add(httpSession.getId());
        }
        return "success";
    }

    /**
     * 向所有在该房间的用户发送消息
     *
     * @param msg
     */
    @RabbitListener(queues = "chat.queue")
    public void sendToRoom(Message msg) {
        log.info("我接受到了实时通信请求：" + msg);
        String roomName = msg.getRoomName();
        Set<String> set = users.get(roomName);
        if (set == null) {
            return;
        }
        for (String s : set) {
            try {
                WebSocketMessage webSocketMessage = new TextMessage(JSON.toJSONString(msg));
                log.info("我打算向http session为" + s + "的用户发送消息");
                SessionManager.get(s).sendMessage(webSocketMessage);
            } catch (IOException e) {
                log.error("发送通知失败." + e.getMessage());
            }
        }
    }
}
