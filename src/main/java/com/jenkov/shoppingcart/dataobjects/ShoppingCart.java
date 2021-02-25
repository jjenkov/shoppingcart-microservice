package com.jenkov.shoppingcart.dataobjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {

    private List<ShoppingCartEntry> entries = new ArrayList<>();

    public void addEntry(ShoppingCartEntry shoppingCartEntry) {
        this.entries.add(shoppingCartEntry);
    }

    public ShoppingCartEntry findEntry(String productId) {
        for(ShoppingCartEntry entry : this.entries) {
            if(entry.getProductId().equals(productId)) {
                return entry;
            }
        }
        return null;
    }

    public boolean removeEntry(String productId) {
        Iterator<ShoppingCartEntry> iterator = this.entries.iterator();
        while(iterator.hasNext()) {
            ShoppingCartEntry entry = iterator.next();
            if(entry.getProductId().equals(productId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<ShoppingCartEntry> getEntries() {
        return this.entries;
    }



}
