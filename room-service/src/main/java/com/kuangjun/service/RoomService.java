package com.kuangjun.service;

import com.kuangjun.model.Message;

import java.util.List;

/**
 * @Author KJ
 * @Date 2023/5/26 下午 2:56
 */
public interface RoomService {
    List<Message> showHistory(String roomName);

    int saveMessage(Message m);
}
