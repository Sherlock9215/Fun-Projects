package com.akshaykhot;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by akshaykhot on 2016-01-11.
 */
public class WeatherTest {

    @Test
    public void testReadFile() {

        //create a sample text file
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("sample.txt");
            writer.println("The first line");
            writer.println("The second line");
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to create the file");
        }

        //try to read the file
        Weather weather = new Weather();
        weather.readFile("sample.txt");

    }

    @Test
    public void testParseFile() {



    }
}
