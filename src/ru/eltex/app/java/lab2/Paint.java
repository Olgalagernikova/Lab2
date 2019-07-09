package ru.eltex.app.java.lab2;
import ru.eltex.app.java.help.Colors;

import java.util.Scanner;

public class Paint extends Product {
    String color;

    public Paint() {
        super();
    }

    public Paint(String message){
        this();
        System.out.println(message);

    }

    public void getType(){

        System.out.println("Paint");
    }


    @Override
    public void create(){
        super.create();
        int i=(int)(Math.random()*(Colors.values().length));
        color=Colors.values()[i].toString();
    }

    @Override
    public void read(){
        super.read();
        System.out.println("Цвет: " + color);
    }

    @Override
    public void update(){
        super.update();
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите цвет краски: ");
        if(sc.hasNextLine()) {
            color = sc.nextLine();

        } else {
            System.out.println("Неверный формат!");
        }
    }

    @Override
    public void delete(){
        super.delete();
        color="";
    }
}
