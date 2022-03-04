package com.example.service;

import com.example.model.Product;
import javafx.beans.binding.MapExpression;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Mặt nạ dưỡng da","Mỹ phẩm","hoa hồng"));
        products.put(2,new Product(2,"Nước rữa mặt","Mỹ phẩm","hoa hồng"));
        products.put(3,new Product(3,"Mặt nạ","Mỹ phẩm","hoa hồng"));
        products.put(4,new Product(4,"Nước tẩy trang","Mỹ phẩm","hoa hồng"));
    }
        @Override
        public List<Product> findAll () {
            return new ArrayList<>(products.values());
        }

        @Override
        public void save (Product product){
            products.put(product.getId(), product);
        }

        @Override
        public Product findById ( int id){
            return products.get(id);
        }

        @Override
        public void update ( int id, Product product){
            products.put(id,product);
        }

        @Override
        public void remove ( int id){
                products.remove(id);
        }

        @Override
        public List<Product> findByName (String name){
           List<Product> productList = new ArrayList<>();
            for (Product product : products.values()){
                    if (product.getNameProduct().contains(name)){
                        productList.add(product);
                    }
        }
            return productList;
        }
    }
