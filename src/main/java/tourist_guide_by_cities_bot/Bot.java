package tourist_guide_by_cities_bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import tourist_guide_by_cities_bot.repository.PlaceRepository;


@Component
public class Bot extends TelegramLongPollingBot {

    // Аннотация @Value позволяет задавать значение полю путем считывания из application.yaml
    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    @Value("${message-to-user.city-is-not-in-the-database}")
    private String messageThatCityNotExist;

    @Autowired
    public PlaceRepository placeRepository;

    @Override
    public void onUpdateReceived(Update update) {

        String city = update.getMessage().getText();
        String messageToUser = null;

        try {

            if (isCityEnteredByUserNotExist(city)) {
                messageToUser = messageThatCityNotExist;

            } else {
                messageToUser = findPlaceDescriptionInDatabase(city);
            }

            sendMessageToUser(messageToUser, update);

        } catch (TelegramApiException e) {
            e.printStackTrace();//логировать
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
        return placeRepository.getPlacesByCity(city) == null;
    }

    private String findPlaceDescriptionInDatabase(String city) {
        return placeRepository.getPlacesByCity(city).getName();
    }

    private void sendMessageToUser(String messageToUser, Update update) throws TelegramApiException {

        execute(new SendMessage().setChatId(update.getMessage().getChatId())
                .setText(messageToUser));
    }

}
