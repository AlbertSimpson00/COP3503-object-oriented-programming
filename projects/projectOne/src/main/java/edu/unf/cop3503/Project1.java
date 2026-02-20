package edu.unf.cop3503;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Project1 is a menu-driven program that reads a list of names
 * separated by commas and provides multiple display and statistical
 * operations on that list.
 *
 * @author Albert Simpson
 * @course COP3503
 */
public class Project1 {

    /**
     * Program entry point. Handles menu looping, user input,
     * and method routing based on user selection.
     *
     * @param args Command line arguments (not used)
     */
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

    /**
     * Displays the program menu options to the user.
     * Provides all available operations that can be
     * performed on the name list.
     */
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

    /**
     * Reads and validates the user's menu selection.
     * Ensures input is an integer between 0 and 9.
     *
     * @param scnr Scanner object for user input
     * @return Validated menu choice
     */
    public static int readChoice(Scanner scnr) {
        while(true) {
            if (scnr.hasNextInt()) {
                int choice = scnr.nextInt();
                scnr.nextLine(); // Consume newline to avoid issues
                if (choice >= 0 && choice <= 9) {
                    return choice;
                }
                System.out.println("Bad input. Please enter a number 0-9.");
            } else {
                System.out.println("Bad input. Please enter a number.");
                scnr.nextLine(); // Discard bad read
            }
        }
    }

    /**
     * Prompts the user to enter a comma-separated list of names,
     * splits the input, and trims whitespace from each entry.
     *
     * @param scnr Scanner object for user input
     * @return Array of cleaned names
     */
    public static String[] readNames(Scanner scnr) {
        System.out.println("Enter List of Names Separated by Commas:");
        String inputLine = scnr.nextLine();

        String[] names = inputLine.split(","); // splits input from line into an array names
        for (int i = 0; i < names.length; i++) { // Iterates over each name for trimming
            names[i] = names[i].trim(); // Trim leading & trailing white spaces from each iteration/name
        }
        return names;
    }

    // ========= Option 1 =========
    /**
     * Displays all names in alphabetical order
     * (case-insensitive) without modifying the original array.
     *
     * @param names Array of names
     */
    public static void displayOrderedList(String[] names) {
        String[] copiedNames = Arrays.copyOf(names, names.length);

        // Sort the copied array alphabetically ignoring uppercase or lowercase
        Arrays.sort(copiedNames, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(copiedNames));
    }
    // ========= Option 2 =========
    /**
     * Displays only full names (names containing spaces)
     * in alphabetical order.
     *
     * @param names Array of names
     */
    public static void displayFullNames(String[] names) {
        String[] copiedNames = Arrays.copyOf(names, names.length);
        Arrays.sort(copiedNames, String.CASE_INSENSITIVE_ORDER); // Added sorting for print formatting

        // Checks if current name contains a space, if it contains a name after .trim()
        // means it must be a full name
        for (int i = 0; i < copiedNames.length; i++) {
            if (copiedNames[i].contains(" ")) {
                System.out.println(copiedNames[i]);
            }
        }
    }
    // ========= Option 3 =========
    /**
     * Displays single names (no spaces)
     * in alphabetical order.
     *
     * @param names Array of names
     */
    public static void displaySingleNames(String[] names) {
        String[] copiedNames = Arrays.copyOf(names, names.length);
        Arrays.sort(copiedNames, String.CASE_INSENSITIVE_ORDER); // Added sorting for print formatting

        for (int i = 0; i < copiedNames.length; i++) {
            // Checks if name does NOT contain space indicating single name
            if (!copiedNames[i].contains(" ")) {
                System.out.println(copiedNames[i]);
            }
        }
    }
    // ========= Option 4 =========
    /**
     * Calculates and displays statistical data about the names list,
     * including count, total letters, average length, shortest name,
     * longest name, and population standard deviation.
     *
     * @param names Array of names
     */
    public static void displayNameStatistics(String[] names) {
        int nameCount = names.length; // Stores total amount of names in array to an integer variable

        int totalLetters = 0; // Counter of all letters across ALL names
        for (int i = 0; i < names.length; i++) {
            // Method call to get length for current name and incrementing counter
            // Helper method helps with excluding spaces to avoid if branching
            totalLetters += lengthWithoutSpaces(names[i]);
        }

        double avgLength = (double) totalLetters/nameCount;

        // Initialize shortest & longest with first element
        String shortest = names[0];
        String longest = names[0];

        // Traverse remaining elements (starting from second element) to determine min and max
        for (int i = 1; i < names.length; i++) {

            // Branching compares & updates if current name has fewer or more letters
            if (lengthWithoutSpaces(names[i]) < lengthWithoutSpaces(shortest)) {
                shortest = names[i];
            }
            if (lengthWithoutSpaces(names[i]) > lengthWithoutSpaces(longest)) {
                longest = names[i];
            }
        }

        // Population Standard deviation
        double variance = sumOfSquares(names, avgLength) / names.length; // Calculate variance using helper method
        double stdDeviation = Math.sqrt(variance); // Calculates population standard deviation

        // ====== Outputs ======
        System.out.println("Name Count: " + nameCount);
        System.out.println("Letter Count Total: " + totalLetters);
        System.out.printf("Avg Name Length: %.2f%n", avgLength);
        System.out.println("Shortest Name: " + shortest);
        System.out.println("Longest Name: " + longest);
        System.out.printf("Population Standard Deviation: %.2f%n", stdDeviation);
    }

    /**
     * Computes the sum of squared differences from the mean
     * name length. Used in standard deviation calculation.
     *
     * @param names Array of names
     * @param avgLength Average name length
     * @return Sum of squared differences
     */
    public static double sumOfSquares(String[] names, double avgLength) {
        double sumSquares = 0;

        for (int i = 0; i < names.length; i++) {
            // Helper method to determine character length of current name
            int length = lengthWithoutSpaces(names[i]);

            // Compute (length − average)^2 and add to the accumulating total
            sumSquares += Math.pow(length - avgLength, 2);
        }

        return sumSquares;
    }
    // ========= Option 5 =========
    /**
     * Displays names whose letter count (excluding spaces)
     * is an even number.
     *
     * @param names Array of names
     */
    public static void displayEvenLengthNames(String[] names) {
        String[] copiedNames = Arrays.copyOf(names, names.length);
        Arrays.sort(copiedNames, String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < copiedNames.length; i++) {
            int nameLength = lengthWithoutSpaces(copiedNames[i]); // Helper method used to determine character length

            if (nameLength % 2 == 0) { // Using modulus operator to determine if length of name is even
                System.out.println(copiedNames[i]);
            }
        }
    }

    /**
     * Calculates the length of a name excluding spaces.
     *
     * @param name Input name
     * @return Character count excluding spaces
     */
    public static int lengthWithoutSpaces(String name) {
        int counter = 0; // Initialize counter to track non-space characters

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != ' ') { // Checker for if character is a space or not
                counter++; // Increments counter if it is not a space
            }
        }
        return counter;
    }
    // ========= Option 6 =========
    /**
     * Displays names whose letter count (excluding spaces)
     * is an odd number.
     *
     * @param names Array of names
     */
    public static void displayOddLengthNames(String[] names) {
        String[] copiedNames = Arrays.copyOf(names, names.length);
        Arrays.sort(copiedNames, String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < copiedNames.length; i++) {
            // Uses helper method found in option 5 section to initialize current name length
            int nameLength = lengthWithoutSpaces(copiedNames[i]);

            if (nameLength % 2 == 1) { // Uses modulo operator to check if length is odd
                System.out.println(copiedNames[i]);
            }
        }
    }
    // ========= Option 7 =========
    /**
     * Displays individual name parts that do not begin
     * with a capital letter.
     *
     * @param names Array of names
     */
    public static void displayNamesNotCapitalized(String[] names) {
        String[] copiedNames = Arrays.copyOf(names, names.length);
        Arrays.sort(copiedNames, String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < copiedNames.length; i++) {
            String[] parts = copiedNames[i].split(" "); // Full names are split using space delimiter

            // Nested loop runs through each part of split name
            for (int j = 0; j < parts.length; j++) {
                // Checks each part if it is not empty and also if the first character is not uppercase
                if (parts[j].length() > 0 && !Character.isUpperCase(parts[j].charAt(0))) {
                    // If both checks pass -> print that part
                    System.out.println(parts[j]);
                }
            }
        }
    }
    // ========= Option 8 =========
    /**
     * Determines and displays the most frequently occurring name
     * in the list (case-insensitive comparison).
     *
     * @param names Array of names
     */
    public static void displayMostFrequentName(String[] names) {
        int frequentCount = 1; // Tracks highest frequency so far
        int frequentIndex = -1; // Stores the index of the most frequent name, -1 means none found yet

        // Outer loop picks each name as the comparator base
        for (int i = 0; i < names.length; i++) {
            int count = 0; // For each name as the comparator base, initialize counter to be 0

            // Nested loop compares comparator base name[i] against every name in the array
            for (int j = 0; j < names.length; j++) {

                // Checks match while ignoring upper or lowercase
                if (names[i].equalsIgnoreCase(names[j])) {
                    count++; // If matches, then increment
                }
            }

            // Once nested loop is finished, checks if name[i] appears more than current best
            // Then updates the best frequency and remembers index of name[i] as current most frequent
            if (count > frequentCount) {
                frequentCount = count;
                frequentIndex = i;
            }
        }

        // If no name beats the starting frequentCount value prints fallback message
        if (frequentIndex == -1) {
            System.out.println("No Most Frequent Name");
        } else { // Otherwise prints the most frequent name found
            System.out.println("Most Frequent Name: " + names[frequentIndex]);
        }
    }
}