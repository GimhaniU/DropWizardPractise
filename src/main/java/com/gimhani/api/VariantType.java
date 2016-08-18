package com.gimhani.api;

/**
 * Created by gimhani on 8/18/16.
 */
public class VariantType {
    private String variantTypeName;
    private Price price;
    private String description;

    public VariantType() {

    }


    public VariantType(String variantTypeName, Price price, String description) {
        this.variantTypeName = variantTypeName;
        this.price = price;
        this.description = description;
    }

    public String getVariantTypeName() {
        return variantTypeName;
    }

    public void setVariantTypeName(String variantTypeName) {
        this.variantTypeName = variantTypeName;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
