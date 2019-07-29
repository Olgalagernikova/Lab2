package ru.eltex.app.java.lab4;


import ru.eltex.app.java.lab3.Order;

public abstract class ACheck implements Runnable{

    protected Orders<Order> orders;
    public boolean fRun=true;
    public long pause;
    Thread th;

    public ACheck(Orders<Order> orders, String stat){
        this.orders = orders;
        th=new Thread(this, stat);
        th.start();
    }

    public void setOrders(Orders<Order> orders) {
        this.orders = orders;
    }

    public Orders<Order> getOrders() {
        return orders;
    }

    public void fStop(){
        fRun=false;
    }

}