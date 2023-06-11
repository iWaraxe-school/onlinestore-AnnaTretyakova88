package com.coherentsolutions.store.http;

import com.coherentsolutions.domain.Product;
import com.coherentsolutions.store.Store;
import com.google.gson.Gson;

import java.io.IOException;

public class Client {
    static Store store;
    public Client (Store store){
        this.store = store;
    }
    public static void clientBuysCheapestItem () throws IOException{
        Product orderedProduct = store.selectItemFromStore();
        Gson g = new Gson();
        String jProduct = g.toJson(orderedProduct);

    }
}
