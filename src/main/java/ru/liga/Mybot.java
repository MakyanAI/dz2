package ru.liga;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.liga.service.Forecaster;

public class Mybot extends TelegramLongPollingBot {

    public static void main(String[] args) {

        Forecaster forecaster = new Forecaster();
       // System.out.println(forecaster.test("rate USD -period month -alg mist -output list"));
        System.out.println(forecaster.test("rate USD -period month -alg mist -output list"));

//        try {
//            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//            botsApi.registerBot(new Mybot());
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            SendMessage message = new SendMessage();
            Forecaster forecaster = new Forecaster();

            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(forecaster.test(update.getMessage().getText()));

            try {
                execute(message);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "MakForecastRateBot";
    }

    @Override
    public String getBotToken() {
        return "5578019861:AAE7NxVkOnitmbFCGobO8twTPihwh4pQVdA";
    }

}
