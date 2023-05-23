package com.kuangjun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
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
     * todo: 查找聊天室、进入聊天室、显示聊天
     *
     */
    @GetMapping("hi")
    public String hi(){
        return "hi";
    }

}
