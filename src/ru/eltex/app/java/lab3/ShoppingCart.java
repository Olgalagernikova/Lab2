package ru.eltex.app.java.lab3;

import ru.eltex.app.java.lab2.Product;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.UUID;

public class ShoppingCart<T extends Product> {

    private ArrayList<T> ShopList;
    TreeSet<UUID> UnicID;

    public ShoppingCart() {

        ShopList = new ArrayList<>();
        UnicID=new TreeSet<>();
    }


    public void add(T prod) {
        ShopList.add(prod);
        if (UnicID.isEmpty() || !UnicID.contains(prod.getId())) {
            UnicID.add(prod.getId());
        }
    }


    public void delete(int index) {
        ShopList.remove(index);
    }


    public ArrayList<T> getShopList() {
        return ShopList;
    }


    //показать все объекты
    public void showShopList() {
        for (int i = 0; i < ShopList.size(); i++) {
            ShopList.get(i).getType();
            ShopList.get(i).read();
        }
    }


    public T searchByID(UUID ID) {
        for (int i = 0; i < ShopList.size(); i++) {
            if (ShopList.get(i).getId().equals(ID)) return ShopList.get(i);
        }
        return null;
    }

}
