package ru.eltex.app.java.lab2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length > 1) {
            String type;
            int n = Integer.parseInt(args[0]);
            Product[] store = new Product[n];
            for (int i = 1, j = 0; i < args.length; i++, j++) {
                type = args[i];
                if (type.equals("Paint")) {
                    store[j] = new Paint();
                } else {
                    if (type.equals("Instrument")) {
                        store[j] = new Instrument();
                    } else {
                        if (type.equals("Materials")) {
                            store[j] = new Materials();
                        } else {
                            System.out.println("Неверный тип товара!");
                        }
                    }
                }
            }


            int i = 0;
            while (i < store.length) {
                store[i].create();
                i++;
            }

            Credentails buyer1 = new Credentails();
            ShoppingCart shoppingCart1 = new ShoppingCart();

            Credentails buyer2 = new Credentails();
            ShoppingCart shoppingCart2 = new ShoppingCart();

            int l;
            for (l = 0; l < store.length - 1; l++) {
                shoppingCart1.add(store[l]);

            }

            shoppingCart2.add(store[l]);

            //shoppingCart.showShopList();
            Order order1 = new Order(buyer1, shoppingCart1);
            //order1.showOrder();

            Order order2 = new Order(buyer2, shoppingCart2);
            //order2.showOrder();

            Orders orders = new Orders();
            orders.addOrder(order1);
            orders.addOrder(order2);

            //orders.showAllOrders();
            orders.makePurchase(0);

        }
    }
}
