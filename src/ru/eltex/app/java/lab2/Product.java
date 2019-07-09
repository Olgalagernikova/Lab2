package ru.eltex.app.java.lab2;
import ru.eltex.app.java.help.ProductName;

import java.util.Scanner;
import java.util.UUID;

public abstract class Product implements ICrudAction {
    private static int count = 0;
    private UUID id;
    private String name;
    private String code;
    private float price;
    private String manufacturer;


    public static String randomString() {
        String tmp = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = (int) (Math.random() * 10 + 5);
        String s = "";
        for (int i = 0; i < length; i++)
            s += tmp.charAt((int) (Math.random() * tmp.length()));
        return s;
    }


    public Product() {
        id = UUID.randomUUID();
    }

    @Override
    public void create() {
        count++;
        int i=(int)(Math.random()*(ProductName.values().length));
        name= ProductName.values()[i].toString();
        price = (float) (Math.random() * 10000);
        code = randomString();
        manufacturer = randomString();
    }

    public float getPrice(){
        return price;
    }

    public UUID getId() {
        return id;
    }

    public abstract void getType();

    @Override
    public void read() {
        System.out.println("ID товара: " + id);
        System.out.println("Название: " + name);
        System.out.println("Артикул: " + code);
        System.out.println("Цена: " + price);
        System.out.println("Производитель: " + manufacturer);
    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите название товара: ");
        if (sc.hasNextLine()) {
            name = sc.nextLine();

        } else {
            System.out.println("Неверный формат!");
        }

        System.out.print("Введите артикул товара: ");
        if (sc.hasNextLine()) {
            code = sc.nextLine();

        } else {
            System.out.println("Неверный формат!");
        }


        System.out.print("Введите цену товара: ");
        if (sc.hasNextFloat()) {
            price = Float.parseFloat(sc.nextLine());
        } else {
            System.out.println("Неверный формат!");
        }

        System.out.print("Введите производитель товара: ");
        if (sc.hasNextLine()) {
            manufacturer = sc.nextLine();
        } else {
            System.out.println("Неверный формат!");
        }

    }

    @Override
    public void delete() {
        count--;
        name = "";
        code = "";
        price = 0;
        manufacturer = "";
    }
}

