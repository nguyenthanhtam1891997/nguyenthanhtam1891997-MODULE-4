package com.example.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    private boolean checkItemCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItem(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemCart(product)) {
            products.put(product, 1);
        } else {
            products.replace(product, selectItem(product).getValue() + 1);
        }
    }

    public void removeProduct(Product product) {
        if (checkItemCart(product)) {
            if (selectItem(product).getValue() > 1) {
                products.replace(product, selectItem(product).getValue() - 1);
            } else {
                products.remove(product);
            }
        }
    }

    public Integer countProduct(){
        return products.size();
    }
    public Float totalPrice(){
        float total = 0;
        for (Map.Entry<Product ,Integer> entry: products.entrySet()){
            total+=entry.getKey().getPrice()*(float)entry.getValue();
        }
        return total;
    }
    public Integer countAllProduct(){
        Integer count =0;
        for (Map.Entry<Product,Integer> entry: products.entrySet()){
            count+= entry.getValue();
        }
        return count;
    }
}
