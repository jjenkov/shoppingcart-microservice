package com.jenkov.shoppingcart.actions;

import com.jenkov.shoppingcart.ShoppingCartException;
import com.jenkov.shoppingcart.dao.ShoppingCartDao;
import com.jenkov.shoppingcart.dataobjects.ShoppingCart;
import com.jenkov.shoppingcart.dataobjects.ShoppingCartEntry;

public class ChangeQuantity {

    private ShoppingCartDao shoppingCartDao = null;

    public ChangeQuantity(ShoppingCartDao shoppingCartDao) {
        this.shoppingCartDao = shoppingCartDao;
    }

    public void changeQuantity(String shoppingCartId, String productId, long quantity) throws Exception {
        ShoppingCart cart = this.shoppingCartDao.getCart(shoppingCartId);

        if(cart == null) {
            throw new ShoppingCartException("Shopping cart with id " + shoppingCartId + " not found");
        }

        //todo possibly validate quantity - e.g. to be > 0 and less than N

        ShoppingCartEntry entry = cart.findEntry(productId);
        if(entry == null) {
            throw new ShoppingCartException("No shopping cart entry found for product id " + productId +
                    " in shopping cart with id " + shoppingCartId);
        }

        entry.setQuantity(quantity);
    }

}
