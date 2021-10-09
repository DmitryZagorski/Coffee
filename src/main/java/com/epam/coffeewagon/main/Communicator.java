package com.epam.coffeewagon.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Communicator {

    public String getStringFromBufferedReader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public double getDoubleFromBufferedReader() {
        Scanner scanner = new Scanner(System.in);
        return Double.parseDouble(scanner.nextLine());

    }
}
