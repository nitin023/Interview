package com.cracking.coding.interview.system.booking.airline.onlineshopping;

public class Customer {
    private Account account;
    private Cart cart;
    private Order order;

    public boolean addItemToCart(Item item){
        return true;
    }

    public boolean removeItemFromCart(Item item){
        return true;
    }

    public OrderStatus placeOrder(Order order){
        return null;
    }
}
