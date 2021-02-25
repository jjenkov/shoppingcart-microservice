package com.jenkov.shoppingcart.actions;

import com.jenkov.shoppingcart.ShoppingCartException;
import com.jenkov.shoppingcart.dao.ProductDao;
import com.jenkov.shoppingcart.dao.ShoppingCartDao;
import com.jenkov.shoppingcart.dataobjects.ShoppingCart;
import com.jenkov.shoppingcart.dataobjects.ShoppingCartEntry;

public class CreateCart {

    private ShoppingCartDao shoppingCartDao = null;

    public CreateCart(ShoppingCartDao shoppingCartDao) {
        this.shoppingCartDao = shoppingCartDao;
    }

    public void createCart(String shoppingCartId) throws Exception {
        ShoppingCart cart = this.shoppingCartDao.getCart(shoppingCartId);

        if(cart != null) {
            throw new ShoppingCartException("Shopping cart with id " + shoppingCartId + " already exists!");
        }

        cart = new ShoppingCart();

        this.shoppingCartDao.addCart(shoppingCartId, cart);
    }


}
