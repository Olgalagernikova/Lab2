package ru.eltex.app.java.lab4;


import ru.eltex.app.java.lab3.Order;

public class Main {

    public static void main(String[] args) {

        //Orders<Order> orders = new Orders<>();
        Generator generator1 = new Generator(3000);//orders, 3000);
        Generator generator2 = new Generator(1000);
        CheckDone checkDone = new CheckDone(generator1.getOrders(), 6000);
        CheckWait checkWait = new CheckWait(generator1.getOrders(), 4000);

        try {
            Thread.sleep(70000);
            generator1.fStop();
            generator2.fStop();
            checkDone.fStop();
            checkWait.fStop();
        } catch (InterruptedException e) {
            generator1.fStop();
            generator2.fStop();
            checkDone.fStop();
            checkWait.fStop();
        }


    }
}
