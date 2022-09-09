package com.bridgelabz.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public  class AddressBookService implements IAddressBook {

    private static final List<Person> personList = new ArrayList<>();

    static JSONArray personArray = new JSONArray();

    public static void searchByCity(List<Person> person) {
        String search;
        List<Person> matches = new ArrayList<>();
        System.out.println("Enter First Name to search : ");
        search = InputUtil.getStringValue();
        int flag = 0;
        for (Person p : person) {
            if (p.getCity().equalsIgnoreCase(search)) {
                flag = 1;
                matches.add(p);
            }
        }
        if (flag == 1) {
            System.out.println("...Match Found...");
            for (Person p : matches) {
                System.out.println(p);
            }
        } else {
            System.out.println("Match Not Found!!!");
        }
    }


    public static void searchByState(List<Person> person) {
        String search;
        int flag = 0;
        List<Person> matches = new ArrayList<>();
        System.out.println("Enter First Name to search : ");
        search = InputUtil.getStringValue();
        for (Person p : person) {
            if (p.getState().equalsIgnoreCase(search)) {
                flag = 1;
                matches.add(p);
            }
        }
        if (flag == 1) {
            System.out.println("...Match Found...");
            for (Person p : matches) {
                System.out.println(p);
            }
        } else {
            System.out.println("Match Not Found!!!");
        }
    }
            public static void sortData(List<Person> person, sortOptions sortOptions){
            person.stream().sorted(sortOptions.comparator).forEach(System.out::println);


    }


    public LinkedList<Person> addRecord(LinkedList<Person> personList) {
        int i = 0;
        String firstName = null;
        final String lastName, address, city, state, phone, zip;
        while (i == 0) {
            System.out.print("Enter First Name : ");
            firstName = InputUtil.getStringValue();
            if (checkExists(firstName,personList)) {
                System.out.println("Person Name Already Exists!!\nPlease enter different name...");
            } else {
                i = 1;
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
        Person person = new Person(firstName, lastName, address, city, state, phone, zip);
        personList.add(person);
        return personList;
    }

    private void writeToJSONFile(Person person) {
        JSONObject personDetails = new JSONObject();
        personDetails.put("first Name",person.getFirstName());
        personDetails.put("last Name",person.getLastName());
        personDetails.put("Phone",person.getPhone());
        personArray.add(personDetails);
        try (FileWriter file = new FileWriter("PersonDetails.json")) {
            file.write(personArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayRecord(LinkedList<Person> person) {
        if (person.isEmpty()) {
            System.out.println("No Records To Display!!!");
        } else {
            person.forEach(System.out::println);
        }
    }


    public LinkedList<Person> editRecord(LinkedList<Person> person) throws AddressBookException {
        int id, i = 0;
        String address, city, state, phone, zip;
        try {
            if (personList.isEmpty()) {
                System.out.println("No Records To Edit!!!");
            } else {
                for (Person person1 : personList) {
                    System.out.println("ID: #" + personList.indexOf(person1) + " : " + person1);
                }
                System.out.print("\nEnter #ID to Edit Contact : ");
                id = InputUtil.getIntValue();
                System.out.println(personList.get(id));
                while (i == 0) {
                    System.out.println("""
                            What You Want to edit...
                            \t1: Address
                            \t2: city
                            \t3: State
                            \t4: Phone
                            \t5: Zip Code
                            \t6. Save And Exit
                            """);
                    int choice = InputUtil.getIntValue();
                    switch (choice) {
                        case 1 -> {
                            System.out.print("Enter new Address : ");
                            address = InputUtil.getStringValue();
                            personList.get(id).setAddress(address);
                        }
                        case 2 -> {
                            System.out.print("Enter new City : ");
                            city = InputUtil.getStringValue();
                            personList.get(id).setCity(city);
                        }
                        case 3 -> {
                            System.out.print("Enter new State : ");
                            state = InputUtil.getStringValue();
                            personList.get(id).setState(state);
                        }
                        case 4 -> {
                            System.out.print("Enter new Phone : ");
                            phone = InputUtil.getStringValue();
                            personList.get(id).setPhone(phone);
                        }
                        case 5 -> {
                            System.out.print("Enter new Zip Code : ");
                            zip = InputUtil.getStringValue();
                            personList.get(id).setZip(zip);
                        }
                        case 6 -> i = 1;
                        default -> System.out.println("Please Enter Valid Option");
                    }
                    System.out.println(personList.get(id));
                }
            }
        } catch (IndexOutOfBoundsException e) {
            throw new AddressBookException("Entered Wrong #ID", AddressBookException.exceptionType.ENTERED_WRONG_ID);
        }
    return person;
    }


    public LinkedList<Person> deleteRecord(LinkedList<Person> personList) throws AddressBookException {
        try {
            int id;
            if (personList.isEmpty()) {
                System.out.println("No Records To Delete!!!");
            } else {
                personList.stream().map(p -> "ID: #" + personList.indexOf(p) + " : " + p).forEach(System.out::println);
                System.out.print("\nEnter #ID to delete Contact : ");
                id = InputUtil.getIntValue();
                personList.remove(id);
                WriteToCsv.writeFromDelete(personList);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new AddressBookException("Entered Wrong #ID", AddressBookException.exceptionType.ENTERED_WRONG_ID);


        }
    return personList;}


            public void sortRecords(LinkedList<Person> personList) {
                System.out.println("""
                        Sort By...
                        1: First Name
                        2: City
                        3: State
                        4: Zip Code
                        5: Back""");
                int choice = InputUtil.getIntValue();
                switch (choice) {
                    case 1:
                        sortData(personList, sortOptions.NAME);
                        break;
                    case 2:
                        sortData(personList, sortOptions.CITY);
                        break;
                    case 3:
                        sortData(personList, sortOptions.STATE);
                        break;
                    case 4:
                        sortData(personList, sortOptions.ZIP);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Please Enter Valid Option...");
                }
            }

    public boolean checkExists(String firstName,LinkedList<Person>person) {
        int flag = person.stream()
                .anyMatch(p -> p.getFirstName().equalsIgnoreCase(firstName)) ? 1 : 0;
        return flag == 1;
    }


    public void searchInRecords(LinkedList<Person> person) {
        int i = 0;
        while (i == 0) {
            System.out.println("""
                    1. Search By City
                    2. Search By State
                    3. Back
                    Choose Your Option""");
            int choice = InputUtil.getIntValue();
            switch (choice) {
                case 1 -> searchByCity(personList);
                case 2 -> searchByState(personList);
                case 3 -> i = 1;
                default -> System.out.println("Please Enter Correct Option...");
            }
        }
    }
}

