package com.jenkov.shoppingcart.dao;

import java.util.HashMap;
import java.util.Map;

public class ProductDaoInMemory implements ProductDao {

    private Map<String, String> productNames = new HashMap<>();


    public void putProductName(String productId, String productName) {
        this.productNames.put(productId, productId);
    }

    @Override
    public String getProductName(String productId) {
        return this.productNames.get(productId);
    }
}
