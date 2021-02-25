package com.jenkov.shoppingcart.actions;

import com.jenkov.shoppingcart.ShoppingCartException;
import com.jenkov.shoppingcart.actions.CreateCart;
import com.jenkov.shoppingcart.dao.ShoppingCartDaoInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CreateCartTest {

    @Test
    public void testCartAlreadyExists() throws Exception {
        ShoppingCartDaoInMemory shoppingCartDao = new ShoppingCartDaoInMemory();

        String cartId = "myCartId";
        CreateCart createCart = new CreateCart(shoppingCartDao);

        createCart.createCart(cartId);

        try {
            createCart.createCart(cartId);
            fail("Expected exception here, when cart with id " + cartId + " already exists");
        } catch(ShoppingCartException e) {
            assertEquals("Shopping cart with id myCartId already exists!", e.getMessage());
        }

    }
}
