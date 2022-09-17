package com.bridgelabz.util;

import com.bridgelabz.Service.AddressBookException;
import com.bridgelabz.Service.AddressBookService;
import com.bridgelabz.Service.sortOptions;

import java.util.ArrayList;
import java.util.List;

import static com.bridgelabz.Service.AddressBookService.searchBy;
import static com.bridgelabz.Service.AddressBookService.sortData;

public class AddressBookUtility {
    AddressBookService addressBookService = new AddressBookService();
    public List<Person> addRecord(List<Person> personList) {
        int flag = 0;
        String firstName = null;
        final String lastName, address, city, state, phone, zip;
        while (flag == 0) {
            firstName = ValidateInputs.validateName("First Name");
            if (checkExists(firstName, personList)) {
                System.out.println("Person Name Already Exists!!\nPlease enter different name...");
            } else {
                flag = 1;
            }
        }
        lastName = ValidateInputs.validateName("Last Name");
        phone = ValidateInputs.validatePhone();
        address = ValidateInputs.validateAddress();
        city = ValidateInputs.validateName("City");
        zip = ValidateInputs.validateZip();
        state = ValidateInputs.validateName("State");
        Person person = new Person(firstName, lastName, address, city, state, zip, phone);
        return addressBookService.addRecord(personList, person);
    }
    public boolean checkExists(String firstName, List<Person> person) {
        int flag = person.stream()
                .anyMatch(p -> p.getFirstName().equalsIgnoreCase(firstName)) ? 1 : 0;
        return flag == 1;
    }
    public List<Person> deleteRecord(List<Person> personList) throws AddressBookException {
        List<Person> deleteRecord = new ArrayList<>();
        try {
            if (personList.isEmpty()) {
                System.out.println("No Records To Delete!!!");
            } else {
                personList.stream().map(p -> "ID: #" + personList.indexOf(p) + " : " + p).forEach(System.out::println);
                System.out.print("\nEnter #ID to delete Contact : ");
                int id = InputUtil.getIntValue();
                deleteRecord = addressBookService.deleteRecord(personList, id);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new AddressBookException("Entered Wrong #ID",
                    AddressBookException.exceptionType.ENTERED_WRONG_ID);
        }
        return deleteRecord;
    }
    public void searchInRecords(List<Person> person) {
        int flag = 0;
        while (flag == 0) {
            System.out.println("1. Search By City\n" +
                    "2. Search By State\n" +
                    "3. Back\n" +
                    "Choose Your Option");
            int choice = InputUtil.getIntValue();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter City Name To Search: ");
                    String city = InputUtil.getStringValue();
                    searchBy(person, city);
                }
                case 2 -> {
                    System.out.println("Enter State Name To Search: ");
                    String state = InputUtil.getStringValue();
                    searchBy(person, state);
                }
                case 3 -> flag = 1;
                default -> System.out.println("Please Enter Correct Option...");
            }
        }
    }
    public void sortRecords(List<Person> personList) {
        System.out.println("Sort By...\n"
                + "1: First Name\n"
                + "2: City\n"
                + "3: State\n"
                + "4: Zip Code\n"
                + "5: Back");
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

}
