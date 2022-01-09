package com.example.telegramservice.service;

import com.example.telegramservice.config.BotConfig;
import com.example.telegramservice.service.messageSender.BotMessageBuilder;
import com.example.telegramservice.service.messageSender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Bot extends TelegramLongPollingBot {

    private final BotConfig config;
    private final String test = "662449862";
    private MessageSender messageSender;

    @Autowired
    public Bot(BotConfig config) {
        this.config = config;
    }

    public void send(String text) {
        var message = SendMessage.builder()
                .chatId(test)
                .text(text)
                .build();

        messageSender.sendMessage(message);
    }

    public void onUpdateReceived(Update update) {
        update.getUpdateId();
        String messageText;
        String chatId;

        if (update.getMessage() != null) {
            chatId = update.getMessage().getChatId().toString();
            messageText = update.getMessage().getText();
        } else {
            chatId = update.getChannelPost().getChatId().toString();
            messageText = update.getChannelPost().getText();
        }

        messageSender.sendMessage(BotMessageBuilder.buildMessage(messageText, chatId));
    }


    public String getBotUsername() {
        return config.getBotUserName();
    }

    public String getBotToken() {
        return config.getToken();
    }

    @Autowired
    public void setMessageSender(@Lazy MessageSender messageSender) {
        this.messageSender = messageSender;
    }
}
