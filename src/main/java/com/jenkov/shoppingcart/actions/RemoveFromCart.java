package com.jenkov.shoppingcart.actions;

import com.jenkov.shoppingcart.ShoppingCartException;
import com.jenkov.shoppingcart.dao.ShoppingCartDao;
import com.jenkov.shoppingcart.dataobjects.ShoppingCart;

public class RemoveFromCart {

    private ShoppingCartDao shoppingCartDao = null;

    public RemoveFromCart(ShoppingCartDao shoppingCartDao) {
        this.shoppingCartDao = shoppingCartDao;
    }

    public boolean removeFromCart(String shoppingCartId, String productId) throws Exception {
        ShoppingCart shoppingCart = this.shoppingCartDao.getCart(shoppingCartId);

        if(shoppingCart == null) {
            throw new ShoppingCartException("No shopping cart found with id " + shoppingCartId);
        }

        return shoppingCart.removeEntry(productId);
    }


}
