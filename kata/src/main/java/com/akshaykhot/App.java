package com.akshaykhot;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        BSearch finder = new BSearch();
        int[] list = {1,3,5,7};
        int foundLocation = finder.findRecursively(9, list);
        if(foundLocation != -1) {
            System.out.println("Item found at : " + foundLocation + " location in the list");
        } else {
            System.out.println("target was not found in the list");
        }
    }
}
