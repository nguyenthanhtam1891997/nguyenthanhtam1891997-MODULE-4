package com.example.model;

public class Product {
    private int id;
    private String nameProduct;
    private String description;
    private String details;

    public Product(int id, String nameProduct, String description, String details) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.description = description;
        this.details = details;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
