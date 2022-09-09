package com.bridgelabz.util;

import java.util.Comparator;

public class Person {
    private String  firstName, lastName, address, city, state, phone,zip;

    public Person(String firstname, String lastname, String address, String city, String state, String phone, String zip)
    {
        this.firstName = firstname;
        this.lastName = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.zip = zip;
    }
    public static Comparator<Person> firstNameSorting = (p1, p2) -> {
        String firstname1 = p1.getFirstName();
        String firstname2 = p2.getFirstName();

        return firstname1.compareTo(firstname2);
    };
    public static Comparator<Person> citySorting = (p1, p2) -> {
        String city1 = p1.getCity();
        String city2 = p2.getCity();

        return city1.compareToIgnoreCase(city2);
    };

    public static Comparator<Person> stateSorting = (p1, p2) -> {
        String state1 = p1.getState();
        String state2 = p2.getState();

        return state1.compareToIgnoreCase(state2);
    };

    public static Comparator<Person> zipSorting = (p1, p2) -> {
        String zip1 = p1.getZip();
        String zip2 = p2.getZip();

        return zip1.compareToIgnoreCase(zip2);
    };

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }




    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phone='" + phone + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}

