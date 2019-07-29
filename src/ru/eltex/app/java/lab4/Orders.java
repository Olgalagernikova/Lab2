package ru.eltex.app.java.lab4;

import ru.eltex.app.java.help.OrderStatus;
import ru.eltex.app.java.lab2.Product;
import ru.eltex.app.java.lab3.Order;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Orders<T extends Order> {
    private LinkedList<T> ordersList;
    private LinkedHashMap<Date, Order> orderMap;

    public Orders() {

        ordersList = new LinkedList<>();
        orderMap = new LinkedHashMap<>();
    }

    public void addOrder(T order) {
        ordersList.add(order);
        orderMap.put(order.getCreationDate(), order);
    }

    public LinkedList<T> getOrdersList() {
        return ordersList;
    }

    public void deleteOrder(T order) {
        ordersList.remove(order);
    }

    public void deleteOrder(int index) {
        ordersList.remove(index);

    }

    public int searchOrder(T order) {
        T ord;
        while (ordersList.iterator().hasNext()) {
            ord = ordersList.iterator().next();
            if (ord.equals(order)) {
                return ordersList.indexOf(ord);
            }
        }
        return -1;
    }

    synchronized public void checkTime() {
        Date checkDate = new Date(System.currentTimeMillis());
        Date nowDate;
        long wait;
        Long waitTime = Long.valueOf(0);
        Iterator <T> iterator= ordersList.iterator();
        int counter = 0;
        T ord;
        while (iterator.hasNext()) {
            ord=iterator.next();

            if (ord.getStatus() == OrderStatus.WAIT.toString()) {

                ord.getOrderTime(checkDate, waitTime);
                nowDate = new Date();
                wait = nowDate.getTime() - checkDate.getTime();

                if (wait > (waitTime.longValue())) {
                    ord.setStatus(OrderStatus.DONE.toString());
                    counter++;
                }
            }
        }
        System.out.println("Orders checked wait: " + counter);
    }


    //проверка заказов
    synchronized public void checkStatus() {
        int pS = ordersList.size();
        Iterator <T> iterator= ordersList.iterator();
        T ord;
       while (iterator.hasNext()) {
            if (iterator.next().getStatus() == OrderStatus.DONE.toString()) {
                synchronized (ordersList) {
                    iterator.remove();
                }
            }

        }
        synchronized (ordersList) {
            System.out.println("Orders checked done: " + (pS - ordersList.size()));
        }
    }


    //оформить покупку
    public void makePurchase(int i) {
        ordersList.get(i).getCustomer().getinfo();//выводим информацию о покупателе
        orderMap.put(ordersList.get(i).getCreationDate(), ordersList.get(i));
        Product prod;
        float finalPrice = 0;
        System.out.println("Список товаров:");

        //выводим список товаров и конечную стоимость покупки
        int cartSize = ordersList.get(i).getCustomerCart().getShopList().size();
        for (int j = 0; j < cartSize; j++) {
            System.out.println("Товар №" + (j + 1));
            prod = ordersList.get(i).getCustomerCart().getShopList().get(j);
            finalPrice += prod.getPrice();
            prod.read();
        }
        System.out.print("Итого:");
        System.out.println(finalPrice);
    }


    public void showAllOrders() {
        for (int i = 0; i < ordersList.size(); i++) {
            System.out.println("Заказ № " + (i + 1));
            ordersList.get(i).showOrder();

        }
    }

}
