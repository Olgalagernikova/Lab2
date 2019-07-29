package ru.eltex.app.java.lab2;

import ru.eltex.app.java.help.OrderStatus;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Orders {
    private LinkedList<Order> ordersList;
    private LinkedHashMap<Date,Order> orderMap;

    public Orders() {

        ordersList = new LinkedList<>();
        orderMap= new LinkedHashMap<>();
    }



    public void addOrder(Order order) {
        ordersList.add(order);
        orderMap.put(order.getCreationDate(),order);
    }


    //проверка заказов
    public void checkOrders() {

        //long currentMilliseconds = new Date().getTime();
        Date checkDate = new Date(System.currentTimeMillis());
        Date nowDate;
        long wait;
        Long waitTime =Long.valueOf(0);

        for (int i = 0; i < ordersList.size(); i++) {
            if (ordersList.get(i).getStatus()== OrderStatus.DONE.toString()) {
                ordersList.remove(i);
            } else {
                ordersList.get(i).getOrderTime(checkDate, waitTime);
                nowDate = new Date();
                wait = nowDate.getTime() - checkDate.getTime();

                if (wait >  (waitTime.longValue() )) {
                    ordersList.get(i).setStatus(OrderStatus.DONE.toString());
                }
            }
        }

    }


    //оформить покупку
    public void makePurchase(int i) {
        ordersList.get(i).getCustomer().getinfo();//выводим информацию о покупателе

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
