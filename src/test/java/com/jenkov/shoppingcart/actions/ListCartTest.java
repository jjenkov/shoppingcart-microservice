package com.jenkov.shoppingcart.actions;

import com.jenkov.shoppingcart.ShoppingCartException;
import com.jenkov.shoppingcart.actions.ListCart;
import com.jenkov.shoppingcart.dao.ShoppingCartDaoInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCartTest {

    @Test
    public void testCartNotFound() throws Exception {
        ShoppingCartDaoInMemory shoppingCartDao = new ShoppingCartDaoInMemory();

        ListCart listCart = new ListCart(shoppingCartDao);

        try {
            listCart.listShoppingCartEntries("cartId");
        } catch(ShoppingCartException e) {
            assertEquals("No shopping cart found with id cartId", e.getMessage());
        }
    }
}
