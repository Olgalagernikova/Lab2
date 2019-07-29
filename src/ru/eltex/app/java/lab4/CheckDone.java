package ru.eltex.app.java.lab4;


import ru.eltex.app.java.lab3.Order;

public class CheckDone extends ACheck {



    public CheckDone(Orders<Order> orders, long pause) {
        super(orders, "Done");
        this.pause=pause;
    }

    @Override
    public void run() {
        while(fRun){
            synchronized (orders){
                orders.checkStatus();
            }
            try{
                Thread.sleep(pause);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }


}
