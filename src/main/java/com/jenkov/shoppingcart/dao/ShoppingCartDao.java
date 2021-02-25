package com.jenkov.shoppingcart.dao;

import com.jenkov.shoppingcart.dataobjects.ShoppingCart;

public interface ShoppingCartDao {

    public void addCart(String shoppingCartId, ShoppingCart shoppingCart);

    public ShoppingCart getCart(String shoppingCartId) throws Exception ;

}
