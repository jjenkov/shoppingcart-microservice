package com.jenkov.shoppingcart.dao;

import java.util.HashMap;
import java.util.Map;

public class ProductDaoInMemory implements ProductDao {

    private Map<String, String> productNames = new HashMap<>();

    public ProductDaoInMemory (){
        putProductName("prodId", "Default Product");
        putProductName("prodId1", "Product 1");
        putProductName("prodId2", "Product 2");
        putProductName("prodId3", "Product 3");
    }

    public void putProductName(String productId, String productName) {
        this.productNames.put(productId, productId);
    }

    @Override
    public String getProductName(String productId) {
        return this.productNames.get(productId);
    }
}
