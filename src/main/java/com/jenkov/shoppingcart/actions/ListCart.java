package com.jenkov.shoppingcart.actions;

import com.jenkov.shoppingcart.ShoppingCartException;
import com.jenkov.shoppingcart.dao.ShoppingCartDao;
import com.jenkov.shoppingcart.dataobjects.ShoppingCart;
import com.jenkov.shoppingcart.dataobjects.ShoppingCartEntry;

import java.util.List;

public class ListCart {

    private ShoppingCartDao shoppingCartDao = null;

    public ListCart(ShoppingCartDao shoppingCartDao) {
        this.shoppingCartDao = shoppingCartDao;
    }


    public List<ShoppingCartEntry> listShoppingCartEntries(String shoppingCartId) throws Exception {
        ShoppingCart shoppingCart = this.shoppingCartDao.getCart(shoppingCartId);

        if(shoppingCart == null) {
            throw new ShoppingCartException("No shopping cart found with id " + shoppingCartId);
        }

        return shoppingCart.getEntries();
    }

}
