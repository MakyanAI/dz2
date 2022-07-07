package ru.liga.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CurrencyRate {

    private int nominal;
    private LocalDate date;
    private double curs;
    private String cdx;

    public CurrencyRate(int nominal, LocalDate date, double curs, String cdx) {
        this.nominal = nominal;
        this.date = date;
        this.curs = curs;
        this.cdx = cdx;
    }

    public CurrencyRate(LocalDate date, double curs) {
        this.date = date;
        this.curs = curs;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getCurs() {
        return curs;
    }

    public void setCurs(double curs) {
        this.curs = curs;
    }

    public String getCdx() {
        return cdx;
    }

    public void setCdx(String cdx) {
        this.cdx = cdx;
    }
}
