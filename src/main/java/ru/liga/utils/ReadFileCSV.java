package ru.liga.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {

    public List<String> readFileCSV(String currency) {

        try {
            String row;
            InputStream inputStream = ReadFileCSV.class.getClassLoader().getResourceAsStream(currency + "_F01_02_2005_T02_07_2022.csv");
            BufferedReader csvReader = new BufferedReader(new InputStreamReader(inputStream));
            List<String> listCurrencyRate = new ArrayList<>();

            while ((row = csvReader.readLine()) != null) {
                listCurrencyRate.add(row);
            }
            csvReader.close();

            return listCurrencyRate;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
