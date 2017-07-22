package com.example;

import java.util.ArrayList;

public class JokesProvider {

    public JokesProvider() {

    }

    private ArrayList<String> jokes;

    public String getJoke() {
        return "How many programmers does it take to change a light bulb?" +
                "\nNone, that's a hardware problem.";
    }
}
