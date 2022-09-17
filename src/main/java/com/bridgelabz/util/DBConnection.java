package com.bridgelabz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final static String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private final static String DB_URL = "jdbc:mysql://localhost:3306/AddressBook?autoReconnect=true&useSSL=false";
    private final static String DB_USERNAME = "root";
    private final static String DB_PASSWORD = "eGain@123";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DB_DRIVER_CLASS);

            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("DB Connection created successfully");
        return con;
    }
}