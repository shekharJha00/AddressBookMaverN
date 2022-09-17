package com.bridgelabz.main;
import com.bridgelabz.Service.*;
import com.bridgelabz.util.AddressBookUtility;
import com.bridgelabz.util.InputUtil;
import com.bridgelabz.util.Person;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AddressBook {
    public static void main(String[] args) throws AddressBookException, IOException, SQLException {

        final String JSON_SIMPLE_FILE_PATH = "src/main/resources/JsonAddressBook.json";
        final String OPEN_CSV_FILE_PATH = "src/main/resources/CsvAddressbook.csv";
        final int jsonSampleOperation = 1, openCSVOperation = 2;
        int operations = 0, flag = 0;
        String filePath = null;
        List<Person> personList;
        FileOperations fileOperations = new FileOperations();
        DataBaseCrudOperations dataBaseCRUDOperations = new DataBaseCrudOperations();
        AddressBookUtility addressBookUtility = new AddressBookUtility();
        SearchSortOperations searchSortOperations = new SearchSortOperations();
        final AddressBookService addressBookService = new AddressBookService();

        System.out.println("Select Below Operations:\n1. JSON SAMPLE\n2. OPEN CSV \n");
        int option = InputUtil.getIntValue();
        switch (option) {
            case 1 -> {
                filePath = JSON_SIMPLE_FILE_PATH;
                operations = jsonSampleOperation;
            }
            case 2 -> {
                filePath = OPEN_CSV_FILE_PATH;
                operations = openCSVOperation;
            }
        }
        while (flag == 0) {
            System.out.println("--- Address Book ---\n");
            System.out.println("\t--MENU--");
            System.out.println("1: Add New Person");
            System.out.println("2: Display Records");
            System.out.println("3: Edit Person");
            System.out.println("4: Delete Person");
            System.out.println("5: Sort");
            System.out.println("6: Search");
            System.out.println("7: Exit\n");
            System.out.println("--- Enter Your Choice ---");
            int choice = InputUtil.getIntValue();
            switch (choice) {
                case 1:
                if (option == 4) {
                    dataBaseCRUDOperations.addRecordToDB();
                    break;
                }
                personList = fileOperations.getDataInList(filePath, operations);
                personList = addressBookUtility.addRecord(personList);
                fileOperations.convertToFile(personList, filePath, operations);
                break;
                case 2:
                    if (option == 4) {
                        List<Person> personDetails = dataBaseCRUDOperations.getDataFromDB();
                        addressBookService.displayRecord(personDetails);
                        break;
                    }
                    List<Person> person = fileOperations.getDataInList(filePath, operations);
                    addressBookService.displayRecord(person);
                    break;
                case 3:
                    if (option == 4) {
                        dataBaseCRUDOperations.editPersonDetails();
                        break;
                    }
                    personList = fileOperations.getDataInList(filePath, operations);
                    personList = addressBookService.editRecord(personList);
                    fileOperations.convertToFile(personList, filePath, operations);

                    break;
                case 4:
                    if (option == 4) {
                        dataBaseCRUDOperations.deleteRecord();
                        break;
                    }
                    personList = fileOperations.getDataInList(filePath, operations);
                    personList = addressBookUtility.deleteRecord(personList);
                    fileOperations.convertToFile(personList, filePath, operations);
                    break;
                case 5:
                    if (option == 4) {
                        searchSortOperations.sortRecords();
                        break;
                    }
                    personList = fileOperations.getDataInList(filePath, operations);
                    addressBookUtility.sortRecords(personList);
                    break;
                case 6:
                    if (option == 4) {
                        searchSortOperations.searchInRecords();
                        break;
                    }
                    personList = fileOperations.getDataInList(filePath, operations);
                    addressBookUtility.searchInRecords(personList);
                    break;
                case 7:
                    flag = 1;
                    break;
                default:
                    System.out.println("Please Enter Valid Option!!!");
            }
        }
    }
}

