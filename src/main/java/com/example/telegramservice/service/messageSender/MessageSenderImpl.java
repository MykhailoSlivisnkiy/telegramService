package com.example.telegramservice.service.messageSender;

import com.example.telegramservice.service.Bot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@Slf4j
public class MessageSenderImpl implements MessageSender {

    private Bot bot;

    @Autowired
    public void setBot(Bot bot) { this.bot = bot; }

    @Override
    public void sendMessage(SendMessage sendMessage) {
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.debug(e.toString());
        }
    }
}
