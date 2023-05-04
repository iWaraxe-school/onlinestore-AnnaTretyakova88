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
    @SneakyThrows
    public void createCategoryTbl(){
        try (Statement stmt =dbConnection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS CATEGORY(NAME VARCHAR(255));");
        }
    }

    @SneakyThrows
    public void createProductTbl(){
        try (Statement stmt =dbConnection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS PRODUCT(NAME VARCHAR(255));");
        }
    }
}





