package com.coherentsolutions;


import com.coherentsolutions.store.DB.Database;
import com.coherentsolutions.store.Store;
import com.coherentsolutions.store.http.Client;
import com.coherentsolutions.store.http.Server;


import java.io.IOException;
import java.sql.SQLException;


import static com.coherentsolutions.store.Store.getInstance;

public class StoreApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        Database db = new Database();
        db.createCategoryTbl();
        db.createProductTbl();

        Store store = getInstance();
        System.out.println("Welcome in Anna Shop! \n");

        Server.runServer();
        Client.clientBuysCheapestItem();

    }
}

//   Scanner scan = new Scanner(System.in);
//    ClearingThread clearingThread = new ClearingThread();
//        new Thread(clearingThread).start();
//        clearingThread.finishRunning();
//
//
//    boolean stop = false;
//        while (!stop) {
//        System.out.println("Type All, Sort, Top5 or Quit");
//        String command = scan.nextLine();
//        switch (command) {
//            case "All":
//                store.printStore();
//                break;
//            case "Sort":
//                store.printSortedProducts();
//                break;
//            case "Top5":
//                store.printTop5Products();
//                break;
//            case "Quit":
//                stop = true;
//                break;
//            case "Order":
//                Runnable createOrder = new CreateOrderThread();
//                new Thread(createOrder).start();
//                break;
//            default:
//                System.out.println("Invalid option");
//        }
//    }
//}

