package com.coherentsolutions.store.http;

import com.sun.net.httpserver.BasicAuthenticator;

public class Authentication extends BasicAuthenticator {
    public Authentication(String input) {super(input);}

    @Override
    public boolean checkCredentials(String userName, String password) {
        return userName.equals("user") && password.equals("pass1");
    }
}
