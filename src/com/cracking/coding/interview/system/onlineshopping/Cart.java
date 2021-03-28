package com.cracking.coding.interview.system.onlineshopping;

import java.util.List;

public class Cart {
    private List<Item> items;

    public boolean addItem(Item item) {
        items.add(item);
        return true;
    }

    public boolean removeItem(Item item) {
        items.remove(item);
        return true;
    }

    public boolean updateItemQuantity(Item item, int quantity) {
        return true;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean checkout() {
        return true;
    }
}
