package com.kuangjun.service.impl;

import com.kuangjun.mapper.RoomMapper;
import com.kuangjun.model.Message;
import com.kuangjun.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author KJ
 * @Date 2023/5/26 下午 2:56
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Message> showHistory(String roomName) {
        return roomMapper.showHistory(roomName);
    }

    @Override
    public int saveMessage(Message m) {
        m.setTime(new Date());
        return roomMapper.saveMessage(m);
    }
}
