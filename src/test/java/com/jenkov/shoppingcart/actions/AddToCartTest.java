package com.jenkov.shoppingcart.actions;

import com.jenkov.shoppingcart.ShoppingCartException;
import com.jenkov.shoppingcart.actions.AddToCart;
import com.jenkov.shoppingcart.actions.CreateCart;
import com.jenkov.shoppingcart.dao.ProductDaoInMemory;
import com.jenkov.shoppingcart.dao.ShoppingCartDaoInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AddToCartTest {

    @Test
    public void testAddCartWithWrongCartId() throws Exception {
        ShoppingCartDaoInMemory shoppingCartDao = new ShoppingCartDaoInMemory();
        ProductDaoInMemory productDao      = new ProductDaoInMemory();

        String cartId = "myCartId";

        CreateCart createCart = new CreateCart(shoppingCartDao);
        createCart.createCart(cartId);

        assertEquals(0, shoppingCartDao.getCart(cartId).getEntries().size());

        AddToCart addToCart = new AddToCart(shoppingCartDao, productDao);

        try{
            addToCart.addEntry(cartId + "XYZ", "prodId", 789);
            fail("Expected exception here because the cartId does not match a shopping cart");
        } catch(ShoppingCartException e) {
            assertEquals("Shopping cart with id myCartIdXYZ not found", e.getMessage());
        }
    }


    @Test
    public void testAddCartWithWrongProductId() throws Exception {
        ShoppingCartDaoInMemory shoppingCartDao = new ShoppingCartDaoInMemory();
        ProductDaoInMemory      productDao      = new ProductDaoInMemory();

        String cartId = "myCartId";

        CreateCart createCart = new CreateCart(shoppingCartDao);
        createCart.createCart(cartId);

        assertEquals(0, shoppingCartDao.getCart(cartId).getEntries().size());

        AddToCart addToCart = new AddToCart(shoppingCartDao, productDao);

        try{
            addToCart.addEntry(cartId, "prodIdXYZ", 789);
            fail("Expected exception here because the productId does not match a real product");
        } catch(ShoppingCartException e) {
            assertEquals("Product with id prodIdXYZ not found", e.getMessage());
        }


    }
}
