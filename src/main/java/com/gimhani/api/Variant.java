package com.gimhani.api;

/**
 * Created by gimhani on 8/18/16.
 */
public class Variant {
    private String name;
    private VariantType[] types;

    public Variant() {

    }

    public Variant(String name, VariantType[] types) {
        this.name = name;
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VariantType[] getTypes() {
        return types;
    }

    public void setTypes(VariantType[] types) {
        this.types = types;
    }
}
