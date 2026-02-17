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

        int optionChoice = -1;
        while (optionChoice != 0) {
            printMenu(); // Figured I'd add this for readability purposes in main
            optionChoice = readChoice(scnr); // Again for maintaining readability

            switch (optionChoice) {
                case 1:
                    System.out.println("1");
                    // displayListOrdered();
                    break;
                case 2:
                    System.out.println("2");
                    displayFullNames(names);
                    break;
                case 3:
                    System.out.println("3");
                    displaySingleNames(names);
                    break;
                case 4:
                    System.out.println("4");
                    // displayNameStatistics();
                    break;
                case 5:
                    System.out.println("5");
                    displayEvenLengthNames(names);
                    break;
                case 6:
                    System.out.println("6");
                    displayOddLengthNames(names);
                    break;
                case 7:
                    System.out.println("7");
                    // displayNamesNotCapitalized();
                    break;
                case 8:
                    System.out.println("8");
                    // displayMostFrequentName();
                    break;
                case 9:
                    System.out.println("9");
                    // names = readNames(scnr);
                    break;
                case 0:
                    System.out.println("Program Exiting");
                    break;
            }

        }
    }

    public static void printMenu() {
        System.out.println();
        System.out.println(); // Readability in terminal


        System.out.println("Please choose an option:");
        System.out.println("1: Display List Ordered");
        System.out.println("2: Display Full Names");
        System.out.println("3: Display Single Names");
        System.out.println("4: Display Name Statistics");
        System.out.println("5: Display Names with Even Length");
        System.out.println("6: Display Names with Odd Length");
        System.out.println("7: Display Names not Capitalized");
        System.out.println("8: Display Most Frequent Name");
        System.out.println("9: Enter new list of Names");
        System.out.println("0: Quit Program");
    }

    public static int readChoice(Scanner scnr) {
        while(true) {
            System.out.print("Choice: ");
            if (scnr.hasNextInt()) {
                int choice = scnr.nextInt();
                scnr.nextLine(); // Consume end of line to avoid issues
                return choice;
            } else {
                System.out.println("Bad input. Please enter a number.");
                scnr.nextLine(); // Discard bad read
            }
        }
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

    // ========= Option 1 =========

    // ========= Option 2 =========
    public static void displayFullNames(String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].contains(" ")) { // Checks if the current element contains a space
                System.out.println(names[i]);
            }
        }
    }
    // ========= Option 3 =========
    public static void displaySingleNames(String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (!names[i].contains(" ")) { // Checks if the current element contains a space
                System.out.println(names[i]);
            }
        }
    }
    // ========= Option 4 =========
    // ========= Option 5 =========
    public static void displayEvenLengthNames(String[] names) {
        for (int i = 0; i < names.length; i++) {
            int nameLength = lengthWithoutSpaces(names[i]);

            if (nameLength % 2 == 0) {
                System.out.println(names[i]);
            }
        }
    }

    public static int lengthWithoutSpaces(String name) {
        int counter = 0;

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != ' ') {
                counter++;
            }
        }
        return counter;
    }
    // ========= Option 6 =========
    public static void displayOddLengthNames(String[] names) {
        for (int i = 0; i < names.length; i++) {
            int nameLength = lengthWithoutSpaces(names[i]); // Uses helper method found in option 5 section

            if (nameLength % 2 == 1) {
                System.out.println(names[i]);
            }
        }
    }
    // ========= Option 7 =========
    // ========= Option 8 =========

}