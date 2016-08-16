package com.gimhani.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by gimhani on 8/16/16.
 */
public class ProductInfo {
    private long productId;
    private String productName;
    private String[] tags;
    private double[] location;
    private float max_price;


    public ProductInfo() {
        // Jackson deserialization
    }

    public ProductInfo(long productId, String productName, String[] tags, double[] location, float max_price) {
        this.productId = productId;
        this.productName = productName;
        this.tags = tags;
        this.location = location;
        this.max_price = max_price;
    }

    @JsonProperty
    public long getProductId() {
        return productId;
    }
    @JsonProperty
    public String getProductName() {
        return productName;
    }
    @JsonProperty
    public String[] getTags() {
        return tags;
    }
    @JsonProperty
    public double[] getLocation() {
        return location;
    }
    @JsonProperty
    public float getMax_price() {
        return max_price;
    }
}
