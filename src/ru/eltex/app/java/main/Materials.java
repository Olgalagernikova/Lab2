package ru.eltex.app.java.main;

import java.util.Scanner;
import java.lang.Math;

public class Materials extends Product {
    float strength;

    public Materials(){
        super();
    }

    public Materials(String message){
        this();
        System.out.println(message);

    }

    public void getType()
    {
        System.out.println("Materials");
    }


    @Override
    public void create(){
        super.create();
        strength=(float)(Math.random() * 1000);
    }

    @Override
    public void read(){
        super.read();
        System.out.println("Прочность: " + strength);
    }

    @Override
    public void update(){
        super.update();
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите прочность материала: ");
        if(sc.hasNextFloat()) {
            strength = sc.nextFloat();

        } else {
            System.out.println("Неверный формат!");
        }
    }

    @Override
    public void delete(){
        super.delete();
        strength=0;
    }
}
