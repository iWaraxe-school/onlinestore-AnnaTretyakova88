package com.coherentsolutions;


import com.coherentsolutions.store.DB.Database;
import com.coherentsolutions.store.Store;
import com.coherentsolutions.store.http.Client;
import com.coherentsolutions.store.http.Server;


import java.io.IOException;
import java.sql.SQLException;


import static com.coherentsolutions.store.Store.getInstance;

public class StoreApp {
    public static void main(String[] args) {

     try  {
         Database db = new Database();
        db.createCategoryTbl();
        db.createProductTbl();

        Store store = getInstance();
        System.out.println("Welcome in Anna Shop! \n");

        Server.runServer();
        Client.clientBuysItem();
     } catch (SQLException | ClassNotFoundException | IOException error){
         System.out.println("Something went wrong" + error.getMessage());
     }
    }
}

