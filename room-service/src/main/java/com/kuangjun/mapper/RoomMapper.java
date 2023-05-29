package com.kuangjun.mapper;

import com.kuangjun.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author KJ
 * @Date 2023/5/26 下午 2:51
 */
@Mapper
@Repository
public interface RoomMapper {
    List<Message> showHistory(String roomName);

    int saveMessage(Message m);
}
