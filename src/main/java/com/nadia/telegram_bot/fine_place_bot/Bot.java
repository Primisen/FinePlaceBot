package com.nadia.telegram_bot.fine_place_bot;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import com.nadia.telegram_bot.fine_place_bot.repository.PlaceRepository;

import java.util.List;

@Component
public class Bot extends TelegramLongPollingBot {

    private Logger logger = Logger.getRootLogger();

    // Аннотация @Value позволяет задавать значение полю путем считывания из application.yaml
    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    @Value("${message-to-user.city-is-not-in-the-database}")
    private String messageThatCityNotExistInDatabase;

    @Autowired
    public PlaceRepository placeRepository;

    @Override
    public void onUpdateReceived(Update update) {

        String city = update.getMessage().getText();
        String messageToUser = null;


        try {

            if (isCityEnteredByUserNotExist(city)) {
                messageToUser = messageThatCityNotExistInDatabase;

            } else {
                messageToUser = createFormattedMessage(city);
            }

            sendMessageToUser(messageToUser, update);

        } catch (TelegramApiException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    private boolean isCityEnteredByUserNotExist(String city) {
        return placeRepository.getPlacesNamesByCity(city).isEmpty();
    }

    private List<String> findPlaceNameInDatabase(String city) {
        return placeRepository.getPlacesNamesByCity(city);
    }

    private void sendMessageToUser(String messageToUser, Update update) throws TelegramApiException {

        execute(new SendMessage().setChatId(update.getMessage().getChatId())
                .setText(messageToUser));
    }

    private String createFormattedMessage(String city) {

        StringBuilder formattedMessage = new StringBuilder();
        formattedMessage
                .append(city)
                .append("\n");
        for (String placeName : findPlaceNameInDatabase(city)) {

            formattedMessage
                    .append("+")
                    .append(" ")
                    .append(placeName)
                    .append("\n");
        }

        return formattedMessage.toString();
    }

}
