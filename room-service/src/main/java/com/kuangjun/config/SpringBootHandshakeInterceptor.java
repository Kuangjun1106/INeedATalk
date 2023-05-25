package com.kuangjun.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author KJ
 * @Date 2023/5/24 下午 2:41
 */
public class SpringBootHandshakeInterceptor implements HandshakeInterceptor {

    /**
     * 握手之前 ServerHttpRequest : 请求对象 ServerHttpResponse : 响应对象 WebSocketHandler :
     * WebSocket服务处理类,在这里指的是SpringBootWebSocketHandler attributes :
     * WebSocketSession.getAttributes()
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        ServletServerHttpRequest servletServerHttpRequest = (ServletServerHttpRequest) serverHttpRequest;
        // 得到Http协议的请求对象
        HttpServletRequest request = servletServerHttpRequest.getServletRequest();
        HttpSession session = request.getSession(true);
        attributes.put("httpSession", session.getId());
        attributes.put("roomName", session.getAttribute("roomName"));
        return true;
    }

    /**
     * 握手之后
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                               Exception exception) {
        // TODO Auto-generated method stub
    }
}