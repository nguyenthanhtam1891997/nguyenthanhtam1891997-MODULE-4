package com.example.productcookiesessien.model;

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

    private Map.Entry<Product, Integer> selectItemCart(Product product) {
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
            Map.Entry<Product, Integer> itemEntry = selectItemCart(product);
            products.replace(itemEntry.getKey(), itemEntry.getValue()+1 );
        }
    }
    public void remove(Product product) {
        if (checkItemCart(product)) {
            Map.Entry<Product, Integer> itemEntry = selectItemCart(product);
            if (itemEntry.getValue()>1){
                products.replace(itemEntry.getKey(), itemEntry.getValue()-1 );
            }else {
                products.remove(product);
            }


        }
    }

    public Integer countItemQuantity(){
        return products.size();
    }

    public Float countTotalPayment() {
        float payment=0;
        for (Map.Entry<Product,Integer> entry: products.entrySet()){
            payment+= entry.getKey().getPrice()*(float)entry.getValue();
        }
        return payment;
    }
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }
}
