package com.jenkov.shoppingcart.actions;

import com.jenkov.shoppingcart.ShoppingCartException;
import com.jenkov.shoppingcart.dao.ProductDao;
import com.jenkov.shoppingcart.dao.ShoppingCartDao;
import com.jenkov.shoppingcart.dataobjects.ShoppingCart;
import com.jenkov.shoppingcart.dataobjects.ShoppingCartEntry;

public class AddToCart {

    private ShoppingCartDao shoppingCartDao = null;
    private ProductDao      productDao      = null;

    public AddToCart(ShoppingCartDao shoppingCartDao, ProductDao productDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.productDao      = productDao;
    }

    public void addEntry(String shoppingCartId, String productId, long quantity) throws Exception {
        ShoppingCart cart = this.shoppingCartDao.getCart(shoppingCartId);

        if(cart == null) {
            throw new ShoppingCartException("Shopping cart with id " + shoppingCartId + " not found");
        }

        String productName = this.productDao.getProductName(productId);
        if(productName == null) {
            throw new ShoppingCartException("Product with id " + productId + " not found");
        }

        //todo possibly validate quantity - e.g. to be > 0 and less than N

        ShoppingCartEntry entry = new ShoppingCartEntry(productId, productName, quantity);

        cart.addEntry(entry);
    }


}
