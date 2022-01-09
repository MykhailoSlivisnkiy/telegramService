package com.example.telegramservice.controller;

import com.example.telegramservice.service.Bot;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping("/goods")
public class GoodsController {

    private final Bot bot;

    @PostMapping("/new-goods")
    public void notifyAboutNewGoods(@RequestBody String text) {
        bot.send(text);
    }
}
