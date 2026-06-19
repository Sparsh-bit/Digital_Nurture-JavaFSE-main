package com.digitalnurture.testing;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<String> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        if (item != null && !item.trim().isEmpty()) {
            items.add(item);
        }
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public int getItemCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }
    
    public boolean contains(String item) {
        return items.contains(item);
    }
}
