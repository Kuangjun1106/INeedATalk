package com.kuangjun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author KJ
 * @Date 2023/5/22 下午 2:04
 */

@Controller
@RequestMapping("/room")
public class RoomController {

    /**
     * todo: 查找聊天室、进入聊天室
     *
     */
    @GetMapping("hi")
    public String hi(){
        return "hi";
    }

}
