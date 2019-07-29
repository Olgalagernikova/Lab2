package ru.eltex.app.java.lab4;

import ru.eltex.app.java.lab2.*;
import ru.eltex.app.java.lab3.Order;
import ru.eltex.app.java.lab3.ShoppingCart;

public class Generator implements Runnable {


    public boolean fRun = true;
    public int pause;

    public static Orders<Order> orders = new Orders<>();
    Thread th;

    public Generator(/*Orders<Order> orders, */int pause) {
        this.pause = pause;
        th = new Thread(this);
        th.start();
    }

    public Orders<Order> getOrders() {
        return orders;
    }

    private ShoppingCart<Product> generateShoppingCart() {

        int length = (int) Math.random() * 10 + 1;
        int t;


        Product[] store = new Product[length];
        for (int i = 0; i < length; i++) {
            t = i % 3;
            switch (t) {
                case 0:
                    store[i] = new Paint();
                    break;
                case 1:
                    store[i] = new Instrument();
                    break;
                case 2:
                    store[i] = new Materials();
                    break;
            }
        }
        int j = 0;
        while (j < store.length) {
            store[j].create();
            j++;
        }

        ShoppingCart<Product> shoppingCart = new ShoppingCart<>();

        for (int l = 0; l < store.length; l++) {
            shoppingCart.add(store[l]);

        }
        return shoppingCart;
    }

    public void fStop() {
        fRun = false;
    }


    @Override
    public void run() {
        while (fRun) {
            Order order = new Order(new Credentails(), generateShoppingCart());
            synchronized (orders) {
                orders.addOrder(order);
                System.out.println("New Order Generated" + orders.getOrdersList().size());
            }
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
