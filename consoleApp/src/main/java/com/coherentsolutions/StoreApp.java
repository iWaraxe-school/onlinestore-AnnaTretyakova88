package com.coherentsolutions;

import com.coherentsolutions.store.RandomStorePopulator;
import com.coherentsolutions.store.Store;
import java.io.Console;

public class StoreApp {
    public static void main(String[] args) {
        Store store = new Store();
        RandomStorePopulator populator = new RandomStorePopulator(store);
        populator.fillByProducts();
        // there should be while loop with readline

        Console console = System.console();

        System.out.println("Welcome in Anna Shop! \n");
        System.out.println("Type All, Sort, Top5 or Quit");

        String command = console.readLine();
        boolean stop = false;
        while (!stop) {

            switch (command) {
                case "All":
                    store.printStore();
                case "Sort":
                    store.printSortedProducts();
                    break;
                case "Top5":
                    store.printTopProducts();
                    break;
                case "Quit":
                    stop = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}

