package com.epam.coffeewagon.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Communicator {

    public String getStringFromBufferedReader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        return s;
    }

    public double getDoubleFromBufferedReader() {
        Scanner scanner = new Scanner(System.in);
        double d = Double.parseDouble(scanner.nextLine());
        scanner.close();
        return d;
    }
}
