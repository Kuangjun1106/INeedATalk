package com.kuangjun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author KJ
 * @Date 2023/5/22 下午 2:30
 */
@Controller
@RequestMapping("/chat")
public class ChatController {
    @GetMapping("hi")
    public String hi(){
        return "hi";
    }

}
