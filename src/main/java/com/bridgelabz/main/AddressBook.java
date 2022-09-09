package com.bridgelabz.main;

import com.bridgelabz.util.AddressBookException;
import com.bridgelabz.util.AddressBookService;
import com.bridgelabz.util.InputUtil;

public class AddressBook {
    public static void main(String[] args) throws AddressBookException {

        int  i = 0;
        final AddressBookService contactDetails = new AddressBookService();
        while (i == 0) {
            {
                System.out.println("--- Address Book ---\n");
                System.out.println("\t--MENU--");
                System.out.println("1: Add New Person      ");
                System.out.println("2: Display Records     ");
                System.out.println("3: Edit Person     ");
                System.out.println("4: Delete Person     ");
                System.out.println("5: Search");
                System.out.println("6: Sort Person");
                System.out.println("7: Exit		       \n");

                System.out.println("--- Enter Your Choice ---");
                int choice = InputUtil.getIntValue();
                switch (choice) {
                    case 1 -> contactDetails.addRecord();
                    case 2 -> contactDetails.displayRecord();
                    case 3 -> contactDetails.editRecord();
                    case 4 -> contactDetails.deleteRecord();
                    case 5 ->contactDetails.searchInRecords();
                    case 6 ->contactDetails.sortRecords();
                    case 7 -> i = 1;
                    default -> System.out.println("Please Enter Valid Option!!!");
                }
            }
        }
    }
}

