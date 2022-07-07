package ru.liga.service;

import ru.liga.repository.CurrencyRate;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MistAlgorithm {
    /**
     * @param parsingListCurrencyRate - распарсенные данные курсов из файла CSV
     * @param date                    - с какой даты начинается прогноз (завтра или конкретная дата в будущем)
     * @param countDay                - количетсво дней прогноза
     * @return - возвращаем прогноз
     */
    public List<CurrencyRate> mistAlgorithm(List<CurrencyRate> parsingListCurrencyRate, LocalDate date, int countDay) {

        List<CurrencyRate> listCurrencyForecastMist;

        listCurrencyForecastMist = parsingListCurrencyRate.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(CurrencyRate::getDate)))
                .limit(30)
//                .filter(d -> d.getDate().isAfter(date.minusDays(31)))
                .collect(Collectors.toList());


        LocalDate startDate = listCurrencyForecastMist.get(0).getDate().plusDays(1);
        LocalDate localDate = date;
        int days = countDay + (int) Duration.between(startDate.atStartOfDay(), localDate.atStartOfDay()).toDays();

        for (int i = 0; i < days; i++) {

            int listSize = listCurrencyForecastMist.size();
            int maxSize = 30;
            int random = 30 - 1;

            if(listSize < 30){
                random = new Random().nextInt(listSize);
                maxSize = listSize;
            }

            Optional<CurrencyRate> currencyRate = listCurrencyForecastMist.stream()
                    .sorted(Collections.reverseOrder(Comparator.comparing(CurrencyRate::getDate)))
                    .limit(maxSize)
                    .skip(random)
                    .findFirst();
            //TODO  .orElseThrow();

            listCurrencyForecastMist.add(new CurrencyRate(startDate, currencyRate.get().getCurs()));
            startDate = startDate.plusDays(1);
        }
        return listCurrencyForecastMist;
    }
}

