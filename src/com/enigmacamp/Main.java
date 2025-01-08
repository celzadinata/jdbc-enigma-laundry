package com.enigmacamp;

import com.enigmacamp.config.DBConnector;
import com.enigmacamp.console.MainConsole;
import com.enigmacamp.utils.InputHandler;

public class Main {
    public static void main(String[] args) {
        DBConnector.getConnection();
        new MainConsole(new InputHandler()).run();
    }
}