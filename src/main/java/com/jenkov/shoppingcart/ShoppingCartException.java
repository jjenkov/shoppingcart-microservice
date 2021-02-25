package com.jenkov.shoppingcart;

public class ShoppingCartException extends Exception {

    public ShoppingCartException() {
    }

    public ShoppingCartException(String message) {
        super(message);
    }

    public ShoppingCartException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShoppingCartException(Throwable cause) {
        super(cause);
    }

    public ShoppingCartException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
