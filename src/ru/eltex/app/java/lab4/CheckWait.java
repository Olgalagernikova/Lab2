package ru.eltex.app.java.lab4;


import ru.eltex.app.java.lab3.Order;

public class CheckWait extends ACheck {


    public CheckWait(Orders<Order> orders, long pause) {
        super(orders, "Wait");
        this.pause=pause;
    }

    @Override
    public void run() {
       while(fRun){
           orders.checkTime();//переделать,разбить на две
           try {
               Thread.sleep(pause);
           }
           catch(InterruptedException e){
               e.printStackTrace();
           }
       }
    }

}
