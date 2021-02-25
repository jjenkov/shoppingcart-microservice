package com.jenkov.shoppingcart.actions;

import com.jenkov.shoppingcart.ShoppingCartException;
import com.jenkov.shoppingcart.actions.AddToCart;
import com.jenkov.shoppingcart.actions.CreateCart;
import com.jenkov.shoppingcart.actions.ListCart;
import com.jenkov.shoppingcart.actions.RemoveFromCart;
import com.jenkov.shoppingcart.dao.ProductDaoInMemory;
import com.jenkov.shoppingcart.dao.ShoppingCartDaoInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveFromCartTest {

    @Test
    public void testCartNotFound() throws Exception {
        ShoppingCartDaoInMemory shoppingCartDao = new ShoppingCartDaoInMemory();

        RemoveFromCart removeFromCart = new RemoveFromCart(shoppingCartDao);

        try {
            removeFromCart.removeFromCart("cartId", "prodId");
            fail("Exptected exception here");
        } catch(ShoppingCartException e) {
            assertEquals("No shopping cart found with id cartId", e.getMessage());
        }
    }

    @Test
    public void testCartEntryNotFound() throws Exception {
        ShoppingCartDaoInMemory shoppingCartDao = new ShoppingCartDaoInMemory();
        ProductDaoInMemory      productDao      = new ProductDaoInMemory();

        String cartId = "cartId";
        CreateCart createCart = new CreateCart(shoppingCartDao);
        createCart.createCart(cartId);

        AddToCart addToCart = new AddToCart(shoppingCartDao, productDao);
        addToCart.addEntry(cartId, "prodId2", 111);

        RemoveFromCart removeFromCart = new RemoveFromCart(shoppingCartDao);

        boolean removed = removeFromCart.removeFromCart("cartId", "prodId");

        assertFalse(removed);
    }
}
