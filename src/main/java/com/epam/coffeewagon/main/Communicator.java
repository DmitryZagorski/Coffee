package com.epam.coffeewagon.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Communicator {

    public String getStringFromBufferedReader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public Double getDoubleFromBufferedReader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(reader.readLine());
    }
}
