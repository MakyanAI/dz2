package ru.liga.utils;

public class CheckMessage {
    public String checkMessage(String inputMessage) {
        if(!inputMessage.contains("rate")) {
            return "Параметр rate обязательный";
        } else if (inputMessage.contains("date") && inputMessage.contains("period")) {
            return "Нельзя передовать параметр -date и -period одновременно";
        } else if (!inputMessage.contains("date") && !inputMessage.contains("period")) {
            return "Необходимо указать параметр -date или -period";
        } else if (!inputMessage.contains("alg")){
            return "Необходимо указать -alg";
        } else if (inputMessage.contains("date") && inputMessage.contains("output")) {
            return "Нельзя передовать параметр -date и -output одновременно";
        }
        return null;
    }
}
