package com.bridgelabz.util;

import java.util.Collections;
import java.util.List;

public class Sort {
    public static void sortByName(List<Person> person)
    {
        Collections.sort(person, Person.firstNameSorting);
        for(Person p: person)
        {
            System.out.println(p);
        }
    }
    public static void sortByCity(List<Person> person)
    {
        Collections.sort(person, Person.citySorting);
        for(Person p: person)
        {
            System.out.println(p);
        }
    }
    public static void sortByState(List<Person> person)
    {
        Collections.sort(person, Person.stateSorting);
        for(Person p: person)
        {
            System.out.println(p);
        }
    }
    public static void sortByZip(List<Person> person)
    {
        Collections.sort(person, Person.zipSorting);
        for(Person p: person)
        {
            System.out.println(p);
        }
    }
}

