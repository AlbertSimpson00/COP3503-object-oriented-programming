package edu.unf.cop3503;

import java.util.Arrays;
import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        String[] names = readNames(scnr);

    }

    public static String[] readNames(Scanner scnr) {
        System.out.println("Enter List of Names Separated by Commas");
        String inputLine = scnr.nextLine();

        String[] names = inputLine.split(","); // splits inputLine into an array names
        for (int i = 0; i < names.length; i++) { // Iterate over each name
            names[i] = names[i].trim(); // Trim white spaces from each iteration/name
        }
        return names;
    }


}