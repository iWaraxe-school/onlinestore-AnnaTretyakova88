package com.coherentsolutions.store.http;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    public static void runServer() throws IOException {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8080), 0);

        HttpContext allProductPage = server.createContext("/products", new AllProductsPage());
        allProductPage.setAuthenticator(new Authentication("get"));

        server.setExecutor(null);
        server.start();
    }
}
