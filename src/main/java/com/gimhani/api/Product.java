package com.gimhani.api;

import java.util.Map;

/**
 * Created by gimhani on 8/18/16.
 */
public class Product {
    private String name;
    private String productId;
    private String description;
    private String[] categories;
    private String[] tags;
    private String[] images;
    private Variant[] variants;

    public Product(){

    }

    public Product(String name, String productId, String description, String[] categories, String[] tags, String[] images, Variant[] variants) {
        this.name = name;
        this.productId = productId;
        this.description = description;
        this.categories = categories;
        this.tags = tags;
        this.images = images;
        this.variants = variants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public Variant[] getVariants() {
        return variants;
    }

    public void setVariants(Variant[] variants) {
        this.variants = variants;
    }
}
