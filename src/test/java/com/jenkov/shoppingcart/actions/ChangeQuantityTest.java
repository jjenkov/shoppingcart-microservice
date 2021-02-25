package com.jenkov.shoppingcart.actions;

import com.jenkov.shoppingcart.ShoppingCartException;
import com.jenkov.shoppingcart.actions.ChangeQuantity;
import com.jenkov.shoppingcart.actions.CreateCart;
import com.jenkov.shoppingcart.dao.ProductDaoInMemory;
import com.jenkov.shoppingcart.dao.ShoppingCartDaoInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ChangeQuantityTest {

    @Test
    public void testShoppingCartNotFound() throws Exception {
        ShoppingCartDaoInMemory shoppingCartDao = new ShoppingCartDaoInMemory();

        ChangeQuantity changeQuantity = new ChangeQuantity(shoppingCartDao);

        try {
            changeQuantity.changeQuantity("cartId", "prodId", 111);
            fail("Expected exception here");
        } catch(ShoppingCartException e) {
            assertEquals("Shopping cart with id cartId not found", e.getMessage());
        }
    }


    @Test
    public void testShoppingCartEntryNotFound() throws Exception {
        ShoppingCartDaoInMemory shoppingCartDao = new ShoppingCartDaoInMemory();
        ProductDaoInMemory productDao = new ProductDaoInMemory();

        String cartId = "cartId";
        CreateCart createCart = new CreateCart(shoppingCartDao);
        createCart.createCart(cartId);

        ChangeQuantity changeQuantity = new ChangeQuantity(shoppingCartDao);

        try {
            changeQuantity.changeQuantity(cartId, "prodId", 111);
            fail("Expected exception here");
        } catch(ShoppingCartException e) {
            assertEquals("No shopping cart entry found for product id prodId in shopping cart with id cartId", e.getMessage());
        }
    }


}
