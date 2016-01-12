package com.akshaykhot;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by akshaykhot on 2016-01-11.
 */
public class WeatherTest {

    PrintWriter writer = null;
    File file = null;

    /**
     * Helper method to create a sample text file for reading and parsing
     */
    public void createFile(String fileName) {
        try {
            writer = new PrintWriter(fileName);
            writer.println("The first line");

            writer.println("The second line");
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to create the file");
        }
    }

    /**
     * Helper method to delete the file after its purpose is finished
     */
    public void deleteFile(String fileName) {
        file = new File(fileName);
        file.delete();
        System.out.println("file was deleted");
    }

    /**
     * test to verify if the code is able to read the file as expected
     */
    @Test
    public void testReadFile() {
        String fileName = "sample.txt";
        createFile(fileName);

        //try to read the file
        Weather weather = new Weather();
        weather.readFile("sample.txt");

        deleteFile(fileName);
    }

    @Test
    public void testParseFile() {
        String fileName = "sample.txt";
        createFile(fileName);

        //try to read the file
        Weather weather = new Weather();
        weather.readFile("sample.txt");
        //try to parse the file
        weather.parseFile(fileName);

        deleteFile(fileName);
    }
}
