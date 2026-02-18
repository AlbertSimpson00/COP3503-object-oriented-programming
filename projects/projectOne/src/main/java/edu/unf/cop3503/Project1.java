package edu.unf.cop3503;

import java.util.Arrays;
import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        String[] names = readNames(scnr);

        int optionChoice = -1;
        while (optionChoice != 0) {
            printMenu(); // Using method for readability purposes in main
            optionChoice = readChoice(scnr); // Method for maintaining readability

            switch (optionChoice) {
                case 1:
                    displayOrderedList(names);
                    break;
                case 2:
                    displayFullNames(names);
                    break;
                case 3:
                    displaySingleNames(names);
                    break;
                case 4:
                    displayNameStatistics(names);
                    break;
                case 5:
                    displayEvenLengthNames(names);
                    break;
                case 6:
                    displayOddLengthNames(names);
                    break;
                case 7:
                    displayNamesNotCapitalized(names);
                    break;
                case 8:
                    displayMostFrequentName(names);
                    break;
                case 9:
                    names = readNames(scnr);
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


        System.out.println("Please make a selection:");
        System.out.println("1) Display List Ordered");
        System.out.println("2) Display Full Names");
        System.out.println("3) Display Single Names");
        System.out.println("4) Display Name Statistics");
        System.out.println("5) Display Names with Even Length");
        System.out.println("6) Display Names with Odd Length");
        System.out.println("7) Display Names not Capitalized");
        System.out.println("8) Display Most Frequent Name");
        System.out.println("9) Enter new list of Names");
        System.out.println("0) Quit Program");
    }

    public static int readChoice(Scanner scnr) {
        while(true) {
            if (scnr.hasNextInt()) {
                int choice = scnr.nextInt();
                scnr.nextLine(); // Consume newline to avoid issues
                if (choice >= 0&& choice <= 9) {
                    return choice;
                }
                System.out.println("Bad input. Please enter a number 0-9.");
            } else {
                System.out.println("Bad input. Please enter a number.");
                scnr.nextLine(); // Discard bad read
            }
        }
    }

    public static String[] readNames(Scanner scnr) {
        System.out.println("Enter List of Names Separated by Commas:");
        String inputLine = scnr.nextLine();

        String[] names = inputLine.split(","); // splits inputLine into an array names
        for (int i = 0; i < names.length; i++) { // Iterate over each name
            names[i] = names[i].trim(); // Trim white spaces from each iteration/name
        }
        return names;
    }

    // ========= Option 1 =========
    public static void displayOrderedList(String[] names) {
        String[] copiedNames = Arrays.copyOf(names, names.length);
        Arrays.sort(copiedNames, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(copiedNames));
    }
    // ========= Option 2 =========
    public static void displayFullNames(String[] names) {
        String[] copiedNames = Arrays.copyOf(names, names.length);
        Arrays.sort(copiedNames, String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < copiedNames.length; i++) {
            if (copiedNames[i].contains(" ")) {
                System.out.println(copiedNames[i]);
            }
        }
    }
    // ========= Option 3 =========
    public static void displaySingleNames(String[] names) {
        String[] copiedNames = Arrays.copyOf(names, names.length);
        Arrays.sort(copiedNames, String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < copiedNames.length; i++) {
            if (!copiedNames[i].contains(" ")) {
                System.out.println(copiedNames[i]);
            }
        }
    }
    // ========= Option 4 =========\
    public static void displayNameStatistics(String[] names) {
        int nameCount = names.length;

        int totalLetters = 0;
        for (int i = 0; i < names.length; i++) {
            totalLetters += lengthWithoutSpaces(names[i]);
        }

        double avgLength = (double) totalLetters/nameCount;

        String shortest = names[0];
        String longest = names[0];

        for (int i = 1; i < names.length; i++) {
            if (lengthWithoutSpaces(names[i]) < lengthWithoutSpaces(shortest)) {
                shortest = names[i];
            }
            if (lengthWithoutSpaces(names[i]) > lengthWithoutSpaces(longest)) {
                longest = names[i];
            }
        }

        // Population Standard deviation
        double variance = sumOfSquares(names, avgLength) / names.length;
        double stdDeviation = Math.sqrt(variance);

        // Prints
        System.out.println("Name Count: " + nameCount);
        System.out.println("Letter Count Total: " + totalLetters);
        System.out.printf("Avg Name Length: %.1f%n", avgLength);
        System.out.println("Shortest Name: " + shortest);
        System.out.println("Longest Name: " + longest);
        System.out.printf("Population Standard Deviation: %.2f%n", stdDeviation);
    }

    public static double sumOfSquares(String[] names, double avgLength) {
        double sumSquares = 0;

        for (int i = 0; i < names.length; i++) {
            int length = lengthWithoutSpaces(names[i]);
            sumSquares += Math.pow(length - avgLength, 2);
        }

        return sumSquares;
    }
    // ========= Option 5 =========
    public static void displayEvenLengthNames(String[] names) {
        String[] copiedNames = Arrays.copyOf(names, names.length);
        Arrays.sort(copiedNames, String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < copiedNames.length; i++) {
            int nameLength = lengthWithoutSpaces(copiedNames[i]);

            if (nameLength % 2 == 0) {
                System.out.println(copiedNames[i]);
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
        String[] copiedNames = Arrays.copyOf(names, names.length);
        Arrays.sort(copiedNames, String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < copiedNames.length; i++) {
            int nameLength = lengthWithoutSpaces(copiedNames[i]); // Uses helper method found in option 5 section

            if (nameLength % 2 == 1) {
                System.out.println(copiedNames[i]);
            }
        }
    }
    // ========= Option 7 =========
    public static void displayNamesNotCapitalized(String[] names) {
        String[] copiedNames = Arrays.copyOf(names, names.length);
        Arrays.sort(copiedNames, String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < copiedNames.length; i++) {
            String[] parts = copiedNames[i].split(" "); // full names are space delimted

            for (int j = 0; j < parts.length; j++) {
                if (parts[j].length() > 0 && !Character.isUpperCase(parts[j].charAt(0))) {
                    System.out.println(parts[j]);
                }
            }
        }
    }
    // ========= Option 8 =========
    public static void displayMostFrequentName(String[] names) {
        int frequentCount = 1;
        int frequentIndex = -1;

        for (int i = 0; i < names.length; i++) {
            int count = 0;

            for (int j = 0; j < names.length; j++) {
                if (names[i].equalsIgnoreCase(names[j])) {
                    count++;
                }
            }

            if (count > frequentCount) {
                frequentCount = count;
                frequentIndex = i;
            }
        }

        if (frequentIndex == -1) {
            System.out.println("No Most Frequent Name");
        } else {
            System.out.println("Most Frequent Name: " + names[frequentIndex]);
        }
    }
}