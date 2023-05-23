package com.kuangjun.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
public class TextHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        if (session.isOpen()) {
            log.info("receive websocket message：{} session:{}", message, session.getId());
            TextMessage returnMessage = new TextMessage(message.getPayload() + " received at server");
            session.sendMessage(returnMessage);
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        //建立连接后保存WebSocketSession会话
        SessionManager.put(session.getId(), session);
        log.info("session[{}] afterConnectionEstablished", session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("session[{}] afterConnectionClosed", session.getId());
        //释放连接后移除WebSocketSession会话
        SessionManager.remove(session.getId());
    }
}