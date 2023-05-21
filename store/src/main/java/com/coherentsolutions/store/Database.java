package com.coherentsolutions.store;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    public Connection dbConnection;

    public Database() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        dbConnection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

    private static class SingleDB{
        private static final Database dataBaseInstance = new Database();
    }

    public void createCategoryTbl(Statement stmt){
        String creatingQuery = "CREATE TABLE IF NOT EXISTS CATEGORIES(" +
                "ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "NAME VARCHAR(255) NOT NULL);";
        try {
            stmt.execute(creatingQuery);
        } catch (SQLException error) {
            System.err.println("Creating Categories table failed" + error.getMessage());
        }
    }

    public void createProductTbl(Statement stmt){
        String creatingQuery = "CREATE TABLE IF NOT EXISTS PRODUCTS(" +
                "ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "NAME VARCHAR(255) NOT NULL," +
                "PRICE INTEGER NOT NULL" +
                "RATE DOUBLE NOT NULL" +
                "CATEGORY_ID INT NOT NULL FOREIGN KEY REFERENCE (CATEGORIES(ID))";
        try {
            stmt.execute(creatingQuery);
        } catch (SQLException error) {
            System.err.println("Creating Products table failed" + error.getMessage());
        }
    }
    public static Database getInstance(){
        return SingleDB.dataBaseInstance;
    }

}





