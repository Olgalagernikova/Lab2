package ru.eltex.app.java.main;

import java.util.Scanner;

public class Instrument extends Product {
    float power;

    public Instrument(){
        super();
    }

    public Instrument(String message){
        this();
        System.out.println(message);
    }

    public void getType()
    {
        System.out.println("Instrument");
    }
    @Override
    public void create(){
        super.create();
        power=(float)(Math.random()*5000);
    }

    @Override
    public void read(){
        super.read();
        System.out.println("Мощность: " + power);
    }

    @Override
    public void update(){
        super.update();

        Scanner sc=new Scanner(System.in);
        System.out.print("Введите мощность инструмента: ");
        if(sc.hasNextFloat()) {
            power = sc.nextFloat();

        } else {
            System.out.println("Неверный формат!");
        }
    }

    @Override
    public void delete(){
        super.delete();
        power=0;
    }

}