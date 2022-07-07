package ru.liga.utils;

import ru.liga.repository.CurrencyRate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Parser {

    public List<CurrencyRate> parsingCurrencyList(List<String> listCurrencyRate){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        ArrayList<CurrencyRate> parsingCurrencyList = new ArrayList<>();

        for (int i = 0; i < listCurrencyRate.size(); i++) {

            if (i != 0) {
                String[] data = listCurrencyRate.get(i).split(";");

                LocalDate date = LocalDate.parse(data[1], dateTimeFormatter);

                String curs = data[2];
                curs = curs.replace(",", ".");
                curs = curs.replaceAll("[^\\d.]", "");

                parsingCurrencyList.add(new CurrencyRate(Integer.parseInt(data[0]), date, Double.parseDouble(curs), data[3]));
            }
        }
        return parsingCurrencyList;
    }
}