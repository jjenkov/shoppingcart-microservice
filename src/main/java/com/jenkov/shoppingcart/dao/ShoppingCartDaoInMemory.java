package com.jenkov.shoppingcart.dao;

import com.jenkov.shoppingcart.dataobjects.ShoppingCart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartDaoInMemory implements ShoppingCartDao {
    private Map<String, ShoppingCart> shoppingCartMap = new HashMap<>();

    @Override
    public void addCart(String shoppingCartId, ShoppingCart shoppingCart) {
        this.shoppingCartMap.put(shoppingCartId, shoppingCart);
    }

    @Override
    public ShoppingCart getCart(String shoppingCartId) throws Exception {
        return this.shoppingCartMap.get(shoppingCartId);
    }




}
