package com.bridgelabz.util;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Contact {
    List<Person> PERSON = new ArrayList<>();

    public void addRecord() {
        int i=0;
        String firstName = null;
        final String lastName, address, city, state, phone,zip;
        while(i==0) {
            System.out.print("Enter First Name : ");
            firstName = InputUtil.getStringValue();
            if (checkExists(firstName)) {
                System.out.println("Person Name Already Exists!!\nPlease enter different name...");
            }
            else {
                i=1;
            }
        }
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

        PERSON.add(new Person(firstName,lastName,address,city,state,phone,zip));
    }
    public void displayRecord() {
        int id;
        for(Person p: PERSON)
        {
            System.out.println("ID: #"+PERSON.indexOf(p)+" : "+p);
        }
        System.out.print("\nEnter #ID to delete Contact : ");
        id = InputUtil.getIntValue();
        PERSON.remove(id);
    }


    public void editRecord() {
        int id, choice, i = 0;
        String firstname, lastname, address, city, state, phone, zip;
        for (Person person : PERSON) {
            System.out.println("ID: #" + PERSON.indexOf(person) + " : " + person);
        }
        System.out.print("\nEnter #ID to Edit Contact : ");
        id = InputUtil.getIntValue();
        System.out.println(PERSON.get(id));
        while (i == 0) {
            System.out.println("""
                    What You Want to edit...
                    \t1: First Name
                    \t2:Last Name
                    \t3: State
                    \t4: Phone
                    \t5: Zip Code
                    \t6. Address
                    \t7.city
                    \t8.Save And Exit
                    """);
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
    public boolean checkExists(String firstname)
    {
        int flag=0;
        for (Person p: PERSON)
        {
            if (p.getFirstName().equals(firstname))
            {
                flag=1;
                break;
            }
        }
        return flag == 1;
    }
    public void searchByCityState()
    {
        int choice;
        System.out.println("""
                Search By
                1: City
                2: State
                3: back""");
        choice=InputUtil.getIntValue();
        switch (choice)
        {
            case 1 :
                Search.searchByCity(PERSON);
                break;
            case 2 :
                Search.searchByState(PERSON);
                break;
            case 3 :
                return;
            default:
                System.out.println("Enter Valid Option");
        }
    }
    public void viewByCityAndState()
    {
        Dictionary<String ,String> cityDict = createCityDict();
        Dictionary<String ,String> stateDict = createStateDict();
        final String city,state;
        System.out.println("Enter City");
        city=InputUtil.getStringValue();
        System.out.println("Enter State");
        state=InputUtil.getStringValue();
        Search.searchByCityAndState(cityDict,stateDict);
    }
    public Dictionary<String,String> createCityDict()
    {
        Dictionary<String,String> cityDict = new Hashtable<>();
        for (Person person:PERSON)
        {
            cityDict.put(person.getFirstName(),person.getCity());
        }
        return cityDict;
    }


    public Dictionary<String,String> createStateDict()
    {
        Dictionary<String,String> stateDict = new Hashtable<>();
        for (Person person:PERSON)
        {
            stateDict.put(person.getFirstName(),person.getState());
        }
        return stateDict;
    }


}

