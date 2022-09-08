package com.bridgelabz.util;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    List<Person> PERSON = new ArrayList<>();

    public void addRecord() {
        final String firstname, lastname, address, city, state, phone, zip;

        System.out.print("Enter First Name : ");
        firstname = InputUtil.getStringValue();
        System.out.print("Enter Last Name : ");
        lastname = InputUtil.getStringValue();
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

        PERSON.add(new Person(firstname, lastname, address, city, state, phone, zip));
    }
    public void displayRecord() {
        for (Person person : PERSON) {
            System.out.println(person);
        }

    }
    public void editRecord() {
        int id, choice = 0, i = 0;
        String firstname, lastname, address, city, state, phone, zip;
        for (Person person : PERSON) {
            System.out.println("ID: #" + PERSON.indexOf(person) + " : " + person);
        }
        System.out.print("\nEnter #ID to Edit Contact : ");
        id = InputUtil.getIntValue();
        System.out.println(PERSON.get(id));
        while (i == 0) {
            System.out.println("What You Want to edit...\n"
                    + "\t1: First Name\n"
                    + "\t2:Last Name\n"
                    + "\t3: State\n"
                    + "\t4: Phone\n"
                    + "\t5: Zip Code\n"
                    + "\t6. Address\n"
                    +"\t7.city\n"
                    +"\t8.Save And Exit\n");
            choice = InputUtil.getIntValue();
            switch (choice) {

                case 1 -> {
                    System.out.println("Enter new First Name :");
                    firstname=InputUtil.getStringValue();
                    PERSON.get(id).setFirstName(firstname);
                }
                case 2 -> {
                    System.out.println("Enter new Last Name : ");
                    lastname=InputUtil.getStringValue();
                    PERSON.get(id).setLastName(lastname);
                }
                case 3 -> {
                    System.out.print("Enter new State : ");
                    state = InputUtil.getStringValue();
                    PERSON.get(id).setState(state);
                }
                case 4 -> {
                    System.out.print("Enter new Phone : ");
                    phone = InputUtil.getStringValue();
                    PERSON.get(id).setPhone(phone);
                }
                case 5 -> {
                    System.out.print("Enter new Zip Code : ");
                    zip = InputUtil.getStringValue();
                    PERSON.get(id).setZip(zip);
                }
                case  6 ->{
                    System.out.print("Enter new Address : ");
                    address = InputUtil.getStringValue();
                    PERSON.get(id).setAddress(address);
                }

                case 7 ->
                {
                    System.out.print("Enter new City : ");
                    city = InputUtil.getStringValue();
                    PERSON.get(id).setCity(city);
                }
                case 8 -> i = 1;
                default -> System.out.println("Please Enter Valid Option");
            }
            System.out.println(PERSON.get(id));
        }
    }

    public void deleteRecord() {
        int id;
        for(Person p: PERSON)
        {
            System.out.println("ID: #"+PERSON.indexOf(p)+" : "+p);
        }
        System.out.print("\nEnter #ID to delete Contact : ");
        id = InputUtil.getIntValue();
        PERSON.remove(id);
    }
}

