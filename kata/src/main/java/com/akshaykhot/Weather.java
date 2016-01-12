package com.akshaykhot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.Scanner;

/**
 * Created by akshaykhot on 2016-01-11.
 */
public class Weather {

    private File weatherFile;
    private Scanner scanner;

    /**
     * reads the weather.txt file and parses it line by line
     */
    public void parseFile(String weatherFileName) {
        readFile(weatherFileName);
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    /**
     * reads a file
     */
    public void readFile(String weatherFileName) {
        weatherFile = new File(weatherFileName);
        try {
            scanner = new Scanner(weatherFile);
            System.out.println("File was read successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
    }
}
