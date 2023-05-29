package com.kuangjun.model;

import java.util.Date;

/**
 * @Author KJ
 * @Date 2023/5/24 上午 8:22
 */
public class Message {
    private String roomName;
    private String nickName;
    private String content;
    private Date time;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "roomName='" + roomName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
