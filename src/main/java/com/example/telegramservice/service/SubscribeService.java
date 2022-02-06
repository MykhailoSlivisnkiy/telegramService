package com.example.telegramservice.service;

import com.example.telegramservice.dto.SubscriptionRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscribeService {

    private final Bot bot;

    public void subscribe(SubscriptionRequest subscriptionRequest) {
        bot.send(subscriptionRequest);
    }
}
