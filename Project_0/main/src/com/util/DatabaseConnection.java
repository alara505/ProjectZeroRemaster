package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection createConnection(){
        try{
            String dbURL = String.format(
                    "jdbc:postgresql://%s:%s/%s?username=%s&password=%s",
                    System.getenv("Host"),
                    System.getenv("PORT"),
                    System.getenv("DBNAME"),
                    System.getenv("USERNAME"),
                    System.getenv("PASSWORD")
            );
            return DriverManager.getConnection(dbURL);
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args){
        System.out.println(createConnection());
    }
}
