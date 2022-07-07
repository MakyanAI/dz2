package ru.liga.service;


import ru.liga.repository.CurrencyRate;
import ru.liga.utils.CheckMessage;
import ru.liga.utils.Parser;
import ru.liga.utils.ParserMessage;
import ru.liga.utils.ReadFileCSV;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forecaster {
    ReadFileCSV readFileCSV = new ReadFileCSV();
    LastYearAlgorithm lastYearAlgorithm = new LastYearAlgorithm();
    MistAlgorithm mistAlgorithm = new MistAlgorithm();
    PrinterForecast printerForecast = new PrinterForecast();
    Parser parser = new Parser();
    CheckMessage checkMessage = new CheckMessage();

    public String test(String inputMessage) {

        List<String> cdx = new ArrayList<>();
        LocalDate localDate = LocalDate.now().plusDays(1);
        int period = 1;
        String alg = null;
        String output = null;

        //TODO только вызывать не проверять
        String error = checkMessage.checkMessage(inputMessage);
        if (error != null) {
            return error;
        }

        try {
            ParserMessage parserMessage = new ParserMessage();
            String[] data = inputMessage.split("-");

            for (int i = 0; i < data.length; i++) {
                if (data[i].contains("rate")) {
                    cdx = parserMessage.parsingMessageTelegramCdx(data[i]);
                } else if (data[i].contains("date")) {
                    localDate = parserMessage.parsingMessageTelegramDate(data[i]);
                } else if (data[i].contains("period")) {
                    period = parserMessage.parsingMessageTelegramPeriod(data[i]);
                } else if (data[i].contains("alg")) {
                    alg = parserMessage.parsingMessageTelegramAlg(data[i]);
                }  else if (data[i].contains("output")) {
                    output = parserMessage.parsingMessageTelegramOutput(data[i]);
                }
            }

            if (cdx == null || alg == null) {
                return "Неверный формат \"Валлюты\" или \"Алгоритма\"";
            }

            List<CurrencyRate> listCurrencyRate = new ArrayList<>();
            for (int i = 0; i < cdx.size(); i++) {
                listCurrencyRate.addAll(parser.parsingCurrencyList(readFileCSV.readFileCSV(cdx.get(i))));

                if (alg.equals("lastYear")) {
                    return printerForecast.printCurrencyForecastTomorrow(
                            lastYearAlgorithm.lastYearAlgorithm(listCurrencyRate, localDate, period), period);

                } else if (alg.equals("mist")) {
                    return printerForecast.printCurrencyForecastTomorrow(
                            mistAlgorithm.mistAlgorithm(listCurrencyRate, localDate, period), period);
                }
            }
        } catch (Exception e) {
            return "Кривой формат сообщения";
        }
        return "Что-то пошло не так!";
    }
}