package com.coherentsolutions.store.http;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class Handler {
    public static void handleResponse(HttpExchange exchange,String data) throws IOException {
        exchange.sendResponseHeaders(200,data.length());
        OutputStream out = exchange.getResponseBody();
        out.write(data.getBytes());
        out.close();
    }
}
