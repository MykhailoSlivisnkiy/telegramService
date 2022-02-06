package com.example.telegramservice.controller;

import com.example.telegramservice.dto.SubscriptionRequest;
import com.example.telegramservice.service.SubscribeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping("/subscribe")
@AllArgsConstructor
public class SubscribeController {

    private final SubscribeService subscribeService;

    @PostMapping
    public void subscribe(@RequestBody SubscriptionRequest subscriptionRequest) {
        subscribeService.subscribe(subscriptionRequest);
    }
}
