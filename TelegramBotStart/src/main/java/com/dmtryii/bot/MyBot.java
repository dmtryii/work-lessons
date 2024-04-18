package com.dmtryii.bot;

import com.dmtryii.config.BotConfig;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return BotConfig.USERNAME;
    }

    @Override
    public String getBotToken() {
        return BotConfig.TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        long chatId = message.getChatId();
        String textMessage = message.getText();

        sendMessage(chatId, "Hello");
        sendMessage(chatId, "Nice to meet you!");
        sendMessage(chatId, textMessage);
    }

    private void sendMessage(long chatId, String textMessage) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(textMessage);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
