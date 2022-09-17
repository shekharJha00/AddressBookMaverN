package com.bridgelabz.Service;

import com.bridgelabz.util.Person;

import java.util.List;

public interface IAddressBook {

    List<Person> addRecord(List<Person> personList, Person person);

    List<Person> editRecord(List<Person> person) throws AddressBookException;

    void displayRecord(List<Person> person);

    List<Person> deleteRecord(List<Person> personList, int id) throws AddressBookException;

}

