package com.jenkov.shoppingcart.actions;

import com.jenkov.shoppingcart.actions.*;
import com.jenkov.shoppingcart.dao.ProductDaoInMemory;
import com.jenkov.shoppingcart.dao.ShoppingCartDaoInMemory;
import com.jenkov.shoppingcart.dataobjects.ShoppingCartEntry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CombiTests {

    @Test
    public void testCreateAddListChangeRemoveNoErrors() throws Exception {
        ShoppingCartDaoInMemory shoppingCartDao = new ShoppingCartDaoInMemory();
        ProductDaoInMemory      productDao      = new ProductDaoInMemory();

        String cartId = "myCartId";

        CreateCart createCart = new CreateCart(shoppingCartDao);
        createCart.createCart(cartId);

        assertEquals(0, shoppingCartDao.getCart(cartId).getEntries().size());

        AddToCart addToCart = new AddToCart(shoppingCartDao, productDao);

        String prodId = "prodId";
        addToCart.addEntry(cartId, prodId, 789);

        assertEquals(1, shoppingCartDao.getCart(cartId).getEntries().size());

        ListCart listCart = new ListCart(shoppingCartDao);

        List<ShoppingCartEntry> entries = listCart.listShoppingCartEntries(cartId);
        assertEquals(1       , entries.size());
        assertEquals(prodId  , entries.get(0).getProductId());
        assertEquals(789     , entries.get(0).getQuantity());


        ChangeQuantity changeQuantity = new ChangeQuantity(shoppingCartDao);
        changeQuantity.changeQuantity(cartId, prodId, 456);

        entries = listCart.listShoppingCartEntries(cartId);
        assertEquals(1       , entries.size());
        assertEquals(prodId  , entries.get(0).getProductId());
        assertEquals(456     , entries.get(0).getQuantity());


        RemoveFromCart removeFromCart = new RemoveFromCart(shoppingCartDao);
        removeFromCart.removeFromCart(cartId, prodId);

        entries = listCart.listShoppingCartEntries(cartId);
        assertEquals(0, entries.size());

    }




}
