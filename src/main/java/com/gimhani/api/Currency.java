package com.gimhani.api;

/**
 * Created by gimhani on 8/18/16.
 */
public class Currency {
    private String code;
    private String symbol;

    public Currency() {

    }

    public Currency(String code, String symbol) {
        this.code = code;
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
