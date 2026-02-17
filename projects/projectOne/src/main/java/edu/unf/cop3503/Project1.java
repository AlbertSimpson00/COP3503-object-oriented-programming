package edu.unf.cop3503;

import java.util.Arrays;
import java.util.Scanner;

public class Project1 {

    /*public static ArrayList<String> newNamesList(String names) {
        ArrayList<String> nameArray = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        char curr = ' ';
        String fullName = temp.toString();

        for(int i = 0; i < names.length(); i++) {
            curr = names.charAt(i);
            if (curr == ',') {
                fullName = fullName.trim();
                nameArray.add(String.valueOf(fullName)); // Convert StringBuilder to type String for namesArray
                temp.setLength(0); // Reset StringBuilder
            } else {
                temp.append(curr);
            }
        }
        nameArray.add(String.valueOf(fullName)); // Add remaining inside temp since last name does not end with "comma"
        return nameArray;
    }
    */


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