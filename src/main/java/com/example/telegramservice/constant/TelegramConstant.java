package com.example.telegramservice.constant;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TelegramConstant {
    public static final String SUBSCRIBE_SUCCESS = "Congratulations. You subscribed to %s. Now you will be notified every time the new goods appear in this shop";
    public static final String NEW_GOODS = "New goods in shop %s";

}
