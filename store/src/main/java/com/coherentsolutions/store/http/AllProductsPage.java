package com.coherentsolutions.store.http;

import com.coherentsolutions.store.Store;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.sql.SQLException;

import static com.coherentsolutions.store.http.Handler.handleResponse;

public class AllProductsPage implements HttpHandler {
      @Override
    public void handle(HttpExchange exchange) throws IOException {
          handleResponse(exchange,"View All Products in our Store! \n" + Store.getProductsFromDB("SELECT * FROM PRODUCTS ORDER BY NAME ASC") );
      }
}