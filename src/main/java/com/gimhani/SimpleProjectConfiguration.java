package com.gimhani;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class SimpleProjectConfiguration extends Configuration {

    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";


    private long productId;
    private String productName;
    private String[] tags;
    private double[] location;
    private float max_price;

    @JsonProperty
    public long getProductId() {
        return productId;
    }
    @JsonProperty
    public void setProductId(long productId) {
        this.productId = productId;
    }
    @JsonProperty
    public String getProductName() {
        return productName;
    }
    @JsonProperty
    public void setProductName(String productName) {
        this.productName = productName;
    }
    @JsonProperty
    public String[] getTags() {
        return tags;
    }
    @JsonProperty
    public void setTags(String[] tags) {
        this.tags = tags;
    }
    @JsonProperty
    public double[] getLocation() {
        return location;
    }
    @JsonProperty
    public void setLocation(double[] location) {
        this.location = location;
    }
    @JsonProperty
    public float getMax_price() {
        return max_price;
    }
    @JsonProperty
    public void setMax_price(float max_price) {
        this.max_price = max_price;
    }

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }
}
