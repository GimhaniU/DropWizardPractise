package com.gimhani.api;

/**
 * Created by gimhani on 8/18/16.
 */
public class Price {
    private Currency currency;
    private double amount;

    public Price() {

    }

    public Price(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
