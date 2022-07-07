package ru.liga.service;

import org.glassfish.grizzly.nio.transport.DefaultStreamWriter;
import ru.liga.repository.CurrencyRate;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrinterForecast {

    public String printCurrencyForecastTomorrow(List<CurrencyRate> parsingListCurrencyRate, int period){

        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        List<CurrencyRate> outputList = parsingListCurrencyRate.stream()
                //.sorted(Comparator.comparing(CurrencyRate::getDate))
                .sorted(Collections.reverseOrder(Comparator.comparing(CurrencyRate::getDate)))
                .limit(period)
                .collect(Collectors.toList());

        Collections.reverse(outputList);
         String result;

        for (int i = 0; i < period; i++){
            CurrencyRate ol = outputList.get(i);
            String localDate = ol.getDate().format(DateTimeFormatter.ofPattern("E  dd.MM.yyyy"));

            result += localDate + " - " + decimalFormat.format(parsingListCurrencyRate.get(i).getCurs()) + "\n";
        }
        return result;
    }
}
