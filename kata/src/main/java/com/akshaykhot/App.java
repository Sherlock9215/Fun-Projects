package com.akshaykhot;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Weather weather = new Weather();
        weather.parseFile("weather.txt");
    }
}
