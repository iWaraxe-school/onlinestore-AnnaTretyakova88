package com.coherentsolutions;

import com.coherentsolutions.store.RandomStorePopulator;
import com.coherentsolutions.store.Store;

public class StoreApp {
    public static void main(String[] args) {
        Store store = new Store();
        RandomStorePopulator populator = new RandomStorePopulator(store);
        populator.fillByProducts();
        store.printStore();
    }
}
