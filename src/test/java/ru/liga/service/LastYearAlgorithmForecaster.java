package ru.liga.service;

import org.junit.Test;
import ru.liga.repository.CurrencyRate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class LastYearAlgorithmForecaster {

    LocalDate localDate = LocalDate.now().minusYears(1);
    List<CurrencyRate> parsingListCurrencyRate = new ArrayList<>();
    LastYearAlgorithm lastYearAlgorithm = new LastYearAlgorithm();

    @Test
    public void testLastYearAlgorithmTomorrow() {

        parsingListCurrencyRate.add(new CurrencyRate(10, localDate.plusDays(1), 99.2753, "Турецкая лира"));
        parsingListCurrencyRate.add(new CurrencyRate(10, localDate.plusDays(2), 99.3234, "Турецкая лира"));
        parsingListCurrencyRate.add(new CurrencyRate(10, localDate.plusDays(3), 99.4312, "Турецкая лира"));

        assertThat(lastYearAlgorithm.lastYearAlgorithm(parsingListCurrencyRate, LocalDate.now().plusDays(1),1))
                .hasSize(1)
                .extracting(CurrencyRate::getDate,CurrencyRate::getCurs)
                .containsExactly(
                        tuple(LocalDate.now().plusDays(1), 9.92753)
                );
    }

    @Test
    public void testLastYearAlgorithmWeek() {

        parsingListCurrencyRate.add(new CurrencyRate(10, localDate.plusDays(1), 99.4944, "Турецкая лира"));
        parsingListCurrencyRate.add(new CurrencyRate(10, localDate.plusDays(2), 99.4945, "Турецкая лира"));
        parsingListCurrencyRate.add(new CurrencyRate(10, localDate.plusDays(3), 99.4946, "Турецкая лира"));
        parsingListCurrencyRate.add(new CurrencyRate(10, localDate.plusDays(4), 99.4947, "Турецкая лира"));
        parsingListCurrencyRate.add(new CurrencyRate(10, localDate.plusDays(5), 99.4948, "Турецкая лира"));
        parsingListCurrencyRate.add(new CurrencyRate(10, localDate.plusDays(6), 99.4949, "Турецкая лира"));
        parsingListCurrencyRate.add(new CurrencyRate(10, localDate.plusDays(7), 99.4950, "Турецкая лира"));

        assertThat(lastYearAlgorithm.lastYearAlgorithm(parsingListCurrencyRate, LocalDate.now().plusDays(1),7))
                .hasSize(7)
                .extracting(CurrencyRate::getDate,CurrencyRate::getCurs)
                .containsExactly(
                        tuple(LocalDate.now().plusDays(1), 9.94944),
                        tuple(LocalDate.now().plusDays(2), 9.94945),
                        tuple(LocalDate.now().plusDays(3), 9.94946),
                        tuple(LocalDate.now().plusDays(4), 9.94947),
                        tuple(LocalDate.now().plusDays(5), 9.94948),
                        tuple(LocalDate.now().plusDays(6), 9.94949),
                        tuple(LocalDate.now().plusDays(7), 9.94950)
                );
    }

    @Test
    public void testLastYearAlgorithmSpecificDate() {

        parsingListCurrencyRate.add(new CurrencyRate(10, LocalDate.now().minusDays(1), 99.4944, "Турецкая лира"));
        parsingListCurrencyRate.add(new CurrencyRate(10, LocalDate.now().minusDays(2), 99.4945, "Турецкая лира"));
        parsingListCurrencyRate.add(new CurrencyRate(10, LocalDate.now().minusDays(3), 99.4946, "Турецкая лира"));

        assertThat(lastYearAlgorithm.lastYearAlgorithm(parsingListCurrencyRate, LocalDate.now().plusYears(5), 1))
                .hasSize(1)
                .extracting(CurrencyRate::getDate, CurrencyRate::getCurs)
                .containsExactly(
                        tuple(LocalDate.now().plusYears(5), 9.94944)
                );
    }
}