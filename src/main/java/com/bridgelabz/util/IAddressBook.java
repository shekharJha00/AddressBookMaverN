package com.bridgelabz.util;

import java.util.LinkedList;

public interface IAddressBook {

    LinkedList<Person> addRecord(LinkedList<Person> personList);

    LinkedList<Person> editRecord(LinkedList<Person> person) throws AddressBookException;

    void displayRecord(LinkedList<Person> person);

    LinkedList<Person> deleteRecord(LinkedList<Person> personList) throws AddressBookException;

    void sortRecords(LinkedList<Person> person);

    void searchInRecords(LinkedList<Person> person);

    boolean checkExists(String firstName, LinkedList<Person> person);
}

