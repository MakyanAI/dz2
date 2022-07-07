package ru.liga.utils;

import org.junit.Assert;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ParserMessage {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public List<String> parsingMessageTelegramCdx(String data) {

        List<String> cdx = new ArrayList<>();
        //TODO справочник
        if (data.contains("AMD")) {
            cdx.add("AMD");
        }
        if (data.contains("BGN")) {
            cdx.add("BGN");
        }
        if (data.contains("EUR")) {
            cdx.add("EUR");
        }
        if (data.contains("TRY")) {
            cdx.add("TRY");
        }
        if (data.contains("USD")) {
            cdx.add("USD");
        }
        return cdx;
    }

    public LocalDate parsingMessageTelegramDate(String data) {
        LocalDate date = null;

        try {
            if (data.contains("tomorrow")) {
                date = LocalDate.now().plusDays(1);
            } else {
                date = LocalDate.parse(data.replaceAll("[^\\d.]", ""), DATE_FORMATTER);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    public int parsingMessageTelegramPeriod(String data) {
        int period = 0;

        if (data.contains("week")) {
            period = 7;
        } else if (data.contains("month")) {
            period = 30;
        } else {
            period = 1;
        }
        return period;
    }

    public String parsingMessageTelegramAlg(String data) {
        String alg = null;

        if (data.contains("moon")) {
            alg = "moon";
        } else if (data.contains("mist")) {
            alg = "mist";
        } else if (data.contains("lastYear")) {
            alg = "lastYear";
        }
        return alg;
    }

    public String parsingMessageTelegramOutput(String data) {
        String output = null;

        if (data.contains("list")) {
            output = "list";
        } else if (data.contains("graph")) {
            output = "graph";
        }
        return output;
    }
}
