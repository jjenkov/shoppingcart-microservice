package com.jenkov.shoppingcart.undertow;

import com.jenkov.shoppingcart.actions.*;
import com.jenkov.shoppingcart.dao.ProductDao;
import com.jenkov.shoppingcart.dao.ProductDaoInMemory;
import com.jenkov.shoppingcart.dao.ShoppingCartDao;
import com.jenkov.shoppingcart.dao.ShoppingCartDaoInMemory;
import com.jenkov.shoppingcart.dataobjects.ShoppingCartEntry;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

import java.util.List;

public class WebHandler implements HttpHandler {

    private ShoppingCartDao shoppingCartDao = new ShoppingCartDaoInMemory();
    private ProductDao      productDao      = new ProductDaoInMemory();

    private CreateCart     createCartAction     = new CreateCart(shoppingCartDao);
    private AddToCart      addToCartAction      = new AddToCart(shoppingCartDao, productDao);
    private RemoveFromCart removeFromCartAction = new RemoveFromCart(shoppingCartDao);
    private ChangeQuantity changeQuantityAction = new ChangeQuantity(shoppingCartDao);
    private ListCart       listCartAction       = new ListCart(shoppingCartDao);


    @Override
    public void handleRequest(HttpServerExchange httpServerExchange) throws Exception {
        String uri = httpServerExchange.getRequestURI();

        switch(uri) {
            case "/create"   : { createCart(httpServerExchange); break; }
            case "/add"      : { addToCart(httpServerExchange); break; }
            case "/remove"   : { removeFromCart(httpServerExchange); break; }
            case "/changeQnt": { changeQuantity(httpServerExchange); break; }
            case "/list"     : { listCart(httpServerExchange); break; }

            default: { notFound(httpServerExchange); }
        }
    }

    private void createCart(HttpServerExchange httpServerExchange) throws Exception {
        String shoppingCartId = getCartIdParam(httpServerExchange);

        this.createCartAction.createCart(shoppingCartId);

        httpServerExchange.getResponseSender().send("OK");
    }

    private void addToCart(HttpServerExchange httpServerExchange) throws Exception {
        String shoppingCartId = getCartIdParam(httpServerExchange);
        String productId      = httpServerExchange.getQueryParameters().get("productId").getFirst();
        String quantityStr    = httpServerExchange.getQueryParameters().get("quantity").getFirst();

        //todo verify that quantity (in string form) is actually an integer
        long quantity = Long.valueOf(quantityStr);

        this.addToCartAction.addEntry(shoppingCartId, productId, quantity);

        //todo send JSON or similar structure back - depending on what the client needs.
        httpServerExchange.getResponseSender().send("OK");
    }

    private String getCartIdParam(HttpServerExchange httpServerExchange) {
        return httpServerExchange.getQueryParameters().get("cartId").getFirst();
    }

    private void removeFromCart(HttpServerExchange httpServerExchange) throws Exception {
        String shoppingCartId = getCartIdParam(httpServerExchange);
        String productId      = httpServerExchange.getQueryParameters().get("productId").getFirst();

        this.removeFromCartAction.removeFromCart(shoppingCartId, productId);

        //todo send JSON or similar structure back - depending on what the client needs.
        httpServerExchange.getResponseSender().send("OK");

    }


    private void changeQuantity(HttpServerExchange httpServerExchange) throws Exception {
        String shoppingCartId = getCartIdParam(httpServerExchange);
        String productId      = httpServerExchange.getQueryParameters().get("productId").getFirst();
        String quantityStr    = httpServerExchange.getQueryParameters().get("quantity").getFirst();

        //todo verify that quantity (in string form) is actually an integer
        long quantity = Long.valueOf(quantityStr);

        this.changeQuantityAction.changeQuantity(shoppingCartId, productId, quantity);

        //todo send JSON or similar structure back - depending on what the client needs.
        httpServerExchange.getResponseSender().send("OK");


    }

    private void listCart(HttpServerExchange httpServerExchange) throws Exception {
        String shoppingCartId = getCartIdParam(httpServerExchange);

        List<ShoppingCartEntry> shoppingCartEntries = this.listCartAction.listShoppingCartEntries(shoppingCartId);

        //todo send JSON or similar structure back - depending on what the client needs.
        httpServerExchange.getResponseSender().send(shoppingCartEntries.toString());

    }



    private void notFound(HttpServerExchange httpServerExchange) {
        httpServerExchange.setStatusCode(404);
        httpServerExchange.getResponseSender().send("Not Found");
    }

}








































