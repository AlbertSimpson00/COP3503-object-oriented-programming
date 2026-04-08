package unf.edu.cop3503;

//import java.util.*;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main driver class for Project 2.
 * Prompts the user for input files, loads data, creates road sections,
 * and writes the output file.
 */
public class Project2 {

    /**
     * Runs the Road Section Data program.
     *
     * @param args command-line arguments not used by this program
     */
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        // Object used to read and write files
        FileHandler fileHandler = new FileHandler();

        // Declaring lists before loading files.
        // Lists will be created when data is successfully loaded.
        ArrayList<RoadVolume> volumeList = null;
        ArrayList<RoadSpeed> speedList = null;

        // The loop condition to continue prompting until a valid input is entered
        boolean goodInput = false;

        while(!goodInput) {

            System.out.println("Enter Path and Name of Volume and Speed Data File");

            String volumeFile = scnr.next();
            String speedFile = scnr.next();

            try {

                // Load the volume file
                System.out.println("Loading Volume Data");
                volumeList = fileHandler.loadVolumeData(volumeFile);
                System.out.println("Volume Data Loaded");

                // Load the speed file
                System.out.println("Loading Speed Data");
                speedList = fileHandler.loadSpeedData(speedFile);
                System.out.println("Speed Data Loaded");

                // Sets our loop condition to true to exit loop once good input is given
                goodInput = true;
            } catch (FileNotFoundException e) {

                System.out.printf("%nFile Not Found Error: %s%n%n", e.getMessage());
            } catch (ParseException e) {

                System.out.printf("%nDate Parse Error: %s%n%n", e.getMessage());
            } catch (NumberFormatException e) {

                System.out.printf("%nNumber Parse Error: %s%n%n", e.getMessage());
            }
        }

        ArrayList<RoadSection> roadSections = createRoadSections(volumeList, speedList);

        try {

            // Writes to the output file using FileHandler object
            fileHandler.writeRoadSectionData(roadSections);

            System.out.println("Road Section Data Created");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error: " + e.getMessage());
        }

        // Close scanner to prevent resource leak, fixed some bugs
        scnr.close();
    }

    /**
     * Creates a list of RoadSection objects by matching volume and speed objects
     * with the same date and time.
     *
     * @param volumeList the list of road volume objects
     * @param speedList the list of road speed objects
     * @return an ArrayList of matching RoadSection objects
     */
    public static ArrayList<RoadSection> createRoadSections(ArrayList<RoadVolume> volumeList, ArrayList<RoadSpeed> speedList) {

        ArrayList<RoadSection> roadSections = new ArrayList<>();

        // Loop through volume records
        for (int i = 0; i < volumeList.size(); i++) {

            RoadVolume volume = volumeList.get(i);

            // Nested loop compares volume records with speed records
            for (int j = 0; j < speedList.size(); j++) {

                RoadSpeed speed = speedList.get(j);

                // Matching condition by date and time
                if (volume.getDate().equals(speed.getDate()) && volume.getTime().equals(speed.getTime())) {

                    // Creates the combined road section
                    roadSections.add(new RoadSection(volume, speed));

                    break;
                }
            }
        }

        return roadSections;
    }
}