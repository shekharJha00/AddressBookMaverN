package com.bridgelabz.util;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    List<Person> p = new ArrayList<>();
    public void addRecord()
    {
        final String firstName, lastName, address, city, state, phone,zip;

        System.out.print("Enter First Name : ");
        firstName = InputUtil.getStringValue();
        System.out.print("Enter Last Name : ");
        lastName = InputUtil.getStringValue();
        System.out.print("Enter Phone Number : ");
        phone = InputUtil.getStringValue();
        System.out.print("Enter Address : ");
        address = InputUtil.getStringValue();
        System.out.print("Enter city : ");
        city = InputUtil.getStringValue();
        System.out.print("Enter zip : ");
        zip = InputUtil.getStringValue();
        System.out.print("Enter state : ");
        state = InputUtil.getStringValue();

        p.add(new Person(firstName,lastName,address,city,state,phone,zip));
    }


    public void displayRecord()
    {
        for(Person p1: p)
        {
            System.out.println(p1);
        }

    }
}

