package ru.liga.service;

import com.github.sh0nk.matplotlib4j.NumpyUtils;
import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import ru.liga.repository.CurrencyRate;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class LastYearAlgorithm {

    public List<CurrencyRate> lastYearAlgorithm(List<CurrencyRate> parsingListCurrencyRate, LocalDate date, int countDay) {

        List<CurrencyRate> listCurrencyForecastYear = new ArrayList<>();
        LocalDate dateForecast = date;

        for (int i = 0; i < countDay; i++) {

            Optional<CurrencyRate> currencyRate = getCurrencyRate(parsingListCurrencyRate, dateForecast);
            listCurrencyForecastYear.add(new CurrencyRate(dateForecast, currencyRate.get().getCurs()));
            dateForecast = dateForecast.plusDays(1);
        }

        return listCurrencyForecastYear;
    }

    private Optional<CurrencyRate> getCurrencyRate(List<CurrencyRate> parsingListCurrencyRate, LocalDate dateForecast) {

        return parsingListCurrencyRate.stream()
                .filter(d -> d.getDate().isBefore(dateForecast.minusYears(1).plusDays(1)))
                .max(Comparator.comparing(CurrencyRate::getDate));
    }
}
