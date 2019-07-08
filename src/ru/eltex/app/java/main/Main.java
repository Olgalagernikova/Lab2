package ru.eltex.app.java.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if(args.length>1) {
            String type;
            int n=Integer.parseInt(args[0]);
            Product[] store = new Product[n];
            for (int i = 1,j=0; i < args.length; i++,j++) {
                type = args[i];
                if (type.equals("Paint")) {
                    store[j] = new Paint();
                } else {
                    if (type.equals("Instrument")) {
                        store[j] = new Instrument();
                    } else {
                        if (type.equals("Materials")) {
                            store[j] = new Materials();
                        } else {
                            System.out.println("Неверный тип товара!");
                        }
                    }
                }
            }

            int numAct;
            Scanner sc = new Scanner(System.in);


            int i=0;
            boolean flag=true;
            while(i<store.length && flag)
            {
                store[i].getType();
                System.out.println("Выберите действие:\n1-create\n2-read\n3-update" +
                        "\n4-delete\n5-next product\n6-exit");

                if(sc.hasNextInt()) {
                    numAct = sc.nextInt();

                    switch (numAct) {
                        case 1:
                            store[i].create();
                            break;
                        case 2:
                            store[i].read();
                            break;
                        case 3:
                            store[i].update();
                            break;
                        case 4:
                            store[i].delete();
                            break;
                        case 5:
                            i++;
                            break;
                        case 6:
                            flag = false;
                            break;
                        default:
                            flag = false;
                            break;

                    }
                }
                else flag=false;

            }

        }
    }
}
