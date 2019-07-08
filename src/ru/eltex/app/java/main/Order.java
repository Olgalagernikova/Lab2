package ru.eltex.app.java.main;

import java.time.LocalDateTime;
import java.util.Date;

public class Order {
    boolean status;
    LocalDateTime creationDate;
    int waitingTime;

    private Credentails customer;
    private ShoppingCart customerCart;

    public Order(){
        status=false;
        creationDate=LocalDateTime.now();
        waitingTime=6;
    }

    public Credentails getCustomer() {
        return customer;
    }

    public ShoppingCart getCustomerCart() {
        return customerCart;
    }


    public void showOrder(){
        customer.getinfo();
        customerCart.showShopList();
    }
}
