package ru.eltex.app.java.main;

import java.util.ArrayList;
import java.util.UUID;

public class ShoppingCart {

    private ArrayList<Product> ShopList;

    public ShoppingCart() {
        ShopList=new ArrayList<>();
    }


    public void add(Product prod){
        ShopList.add(prod);
    }


    public void delete(int index) {
        ShopList.remove(index);
    }


    public ArrayList<Product> getShopList(){
        return ShopList;
    }


    //показать все объекты
    public void showShopList(){
        for(int i=0;i<ShopList.size();i++) {
            ShopList.get(i).getType();
            ShopList.get(i).read();
        }
    }


    public Product searchByID(UUID ID){
        for(int i=0;i<ShopList.size();i++) {
            if (ShopList.get(i).getId().equals(ID)) return ShopList.get(i);
        }
        return null;
    }

}
