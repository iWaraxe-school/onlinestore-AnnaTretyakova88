package com.coherentsolutions.store.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private Connection dbConnection;

    public Database() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        dbConnection = DatabaseConnection.getConnection();
    }


    public void createCategoryTbl() throws SQLException {
        Statement stmt = dbConnection.createStatement();
        String creatingQuery = "CREATE TABLE IF NOT EXISTS CATEGORIES(" +
                "ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "NAME VARCHAR(255) NOT NULL);";
        try {
            stmt.execute(creatingQuery);
        } catch (SQLException error) {
            System.err.println("Creating Categories table failed" + error.getMessage());
            error.printStackTrace();
        }
    }

    public void createProductTbl() throws SQLException {
        Statement stmt = dbConnection.createStatement();
        String creatingQuery = "CREATE TABLE IF NOT EXISTS PRODUCTS(" +
                "ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "NAME VARCHAR(255) NOT NULL," +
                "PRICE INTEGER NOT NULL," +
                "RATE DOUBLE NOT NULL," +
                "CATEGORY_ID INT NOT NULL," +
                "FOREIGN KEY (CATEGORY_ID) REFERENCE (CATEGORIES(ID))";
        try {
            stmt.execute(creatingQuery);
        } catch (SQLException error) {
            System.err.println("Creating Products table failed" + error.getMessage());
            error.printStackTrace();
        }
    }
//    public void createOrderTbl(Statement stmt){
//        String creatingQuery = "CREATE TABLE IF NOT EXISTS ORDERS(" +
//                "ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
//                "PRODUCT_ID INT NOT NULL FOREIGN KEY REFERENCE (PRODUCTS(ID))" +
//                "NAME VARCHAR(255) NOT NULL," +
//                "PRICE INTEGER NOT NULL" +
//                "RATE DOUBLE NOT NULL" +
//                "CATEGORY_ID INT NOT NULL FOREIGN KEY REFERENCE (CATEGORIES(ID))"+
//                "QUANTITY INT NOT NULL";
//        try {
//            stmt.execute(creatingQuery);
//        } catch (SQLException error) {
//            System.err.println("Creating Orders table failed" + error.getMessage());
//        }
//    }

}





