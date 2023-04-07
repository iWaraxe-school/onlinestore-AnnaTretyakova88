package com.coherentsolutions;

import com.coherentsolutions.store.ClearingThread;
import com.coherentsolutions.store.CreateOrderThread;
import com.coherentsolutions.store.RandomStorePopulator;
import com.coherentsolutions.store.Store;
import java.io.Console;
import java.util.Scanner;

import static com.coherentsolutions.store.Store.getInstance;

public class StoreApp {
    public static void main(String[] args) {
        Store store = getInstance();

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome in Anna Shop! \n");

        ClearingThread clearingThread = new ClearingThread();
        new Thread(clearingThread).start();
        clearingThread.finishRunning();


        boolean stop = false;
        while (!stop) {
            System.out.println("Type All, Sort, Top5 or Quit");
            String command = scan.nextLine();
            switch (command) {
                case "All":
                    store.printStore();
                    break;
                case "Sort":
                    store.printSortedProducts();
                    break;
                case "Top5":
                    store.printTopProducts();
                    break;
                case "Quit":
                    stop = true;
                    break;
                case "Order":
                    Runnable createOrder = new CreateOrderThread();
                    new Thread(createOrder).start();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}

