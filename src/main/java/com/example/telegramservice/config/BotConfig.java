package com.example.telegramservice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class BotConfig {
    @Value("${botUserName}")
    String botUserName;

    // Токен полученный при регистрации
    @Value("${token}")
    String token;
}
