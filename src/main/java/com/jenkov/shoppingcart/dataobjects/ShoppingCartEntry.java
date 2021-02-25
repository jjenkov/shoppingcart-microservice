package com.jenkov.shoppingcart.dataobjects;

public class ShoppingCartEntry {

    private String productId   = null;
    private String productName = null;
    private long   quantity    = 0;


    public ShoppingCartEntry() {
    }

    public ShoppingCartEntry(String productId, String productName, long quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity  = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "{ \"productId\" : \"" + this.productId + "\", \"productName\" : " + this.productName +
                "\", \"quantity\" : " + this.quantity + "\" }";
    }

}
