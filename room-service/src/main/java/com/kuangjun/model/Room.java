package com.kuangjun.model;

/**
 * @Author KJ
 * @Date 2023/5/24 上午 8:41
 */
public class Room {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }
}
