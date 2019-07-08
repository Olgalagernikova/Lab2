package ru.eltex.app.java.main;

import java.util.LinkedList;

public class Orders {
    private LinkedList<Order> ordersList;

    public Orders(){

        ordersList=new LinkedList<>();
    }

    public void makePurchase(int i) {
        ordersList.get(i).getCustomer().getinfo();//выводим информацию о покупателе

        Product prod;
        float finalPrice=0;
        System.out.println("Список товаров:");

        //выводим список товаров и конечную стоимость покупки
        int cartSize=ordersList.get(i).getCustomerCart().getShopList().size();
        for(int j=0;j<cartSize;j++){
           prod= ordersList.get(i).getCustomerCart().getShopList().get(j);
           finalPrice+=prod.getPrice();
           prod.read();
        }
        System.out.print("Итого:");
        System.out.println(finalPrice);
    }


    public void showAllOrders(){
        for(int i=0;i<ordersList.size();i++) {
            ordersList.get(i).showOrder();
        }
    }

}
