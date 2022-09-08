package com.bridgelabz.main;

import com.bridgelabz.util.Contact;
import com.bridgelabz.util.InputUtil;

public class AddressBook {
    public static void main(String[] args) {

            int choice,i=0;
            final Contact contactDetails = new Contact();
            while(i==0)
            {
                System.out.println("--- Address Book ---\n");
                System.out.println("\t--MENU--");
                System.out.println("1: Add New Person      ");
                System.out.println("2: Display Records     ");
                System.out.println("3: Exit		       \n");

                System.out.println("--- Enter Your Choice ---");
                choice = InputUtil.getIntValue();
                switch (choice) {
                    case 1 -> contactDetails.addRecord();
                    case 2 -> contactDetails.displayRecord();
                    case 3 -> i = 1;
                    default -> System.out.println("Please Enter Valid Option!!!");
                }
            }
    }
}


