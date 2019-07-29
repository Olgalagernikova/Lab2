package ru.eltex.app.java.lab3;


import ru.eltex.app.java.help.OrderStatus;
import ru.eltex.app.java.lab2.Credentails;
import ru.eltex.app.java.lab2.Product;

import java.util.Date;

public class Order {


    String status;



    Date creationDate;
    long waitingTime;

    private Credentails customer;
    private ShoppingCart<Product> customerCart;

    public Order(){
        status = OrderStatus.WAIT.toString();
        creationDate=new Date(System.currentTimeMillis());
        waitingTime=(long)(Math.random()*10);
    }

    public Order(Credentails credentails, ShoppingCart<Product> shoppingCart)
    {
        this();
        customer=credentails;
        customerCart=shoppingCart;
    }



    public void offer(Credentails credentails, ShoppingCart<Product> shoppingCart){
        customer=credentails;
        customerCart=shoppingCart;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void getOrderTime(Date checkDate,Long checkWaitTime ){
        checkDate=creationDate;
        checkWaitTime=waitingTime;
    }
    public Date getCreationDate() {
        return creationDate;
    }


    public void printStatus(){
        System.out.println(status);
    }

    public Credentails getCustomer() {
        return customer;
    }

    public ShoppingCart<Product> getCustomerCart() {
        return customerCart;
    }


    public void showOrder(){
        System.out.println("Время создания:"+ creationDate);
        System.out.println("Время ожидания:"+ waitingTime);
        customer.getinfo();
        System.out.println("Список покупок:");
        customerCart.showShopList();
        printStatus();
    }
}
