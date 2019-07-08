package ru.eltex.app.java.main;

import ru.eltex.app.java.help.Email;
import ru.eltex.app.java.help.FirstName;
import ru.eltex.app.java.help.LastName;
import ru.eltex.app.java.help.PatronicName;

import java.util.UUID;

public class Credentails {
    private UUID ID;
    private String lastName;
    private String firstName;
    private String patronicName;
    private String email;

    public Credentails(){
        ID =UUID.randomUUID();

        int i=(int)(Math.random()*(LastName.values().length));
        lastName= LastName.values()[i].toString();

        i=(int)(Math.random()*(LastName.values().length));
        firstName= FirstName.values()[i].toString();

        i=(int)(Math.random()*(PatronicName.values().length));
        patronicName=PatronicName.values()[i].toString();

        i=(int)(Math.random()*(Email.values().length));
        email=firstName+lastName+'@'+ Email.values()[i].toString();
    }

    public void getinfo(){
        System.out.println(ID);
        System.out.println(lastName);
        System.out.println(firstName);
        System.out.println(patronicName);
        System.out.println(email);
    }



}
