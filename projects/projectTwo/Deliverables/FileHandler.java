package unf.edu.cop3503;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles reading input data files and writing the output data file
 * for the Road Section Data program.
 */
public class FileHandler {

    /**
     * Creates a FileHandler object.
     */
    public FileHandler() {
    }

    /**
     * Reads the volume data file and stores each row in a RoadVolume object.
     *
     * @param fileName the name or path of the volume data file
     * @return an ArrayList of RoadVolume objects
     * @throws FileNotFoundException if the file cannot be found
     * @throws ParseException if a date cannot be parsed
     * @throws NumberFormatException if a numeric value cannot be parsed
     */
    public ArrayList<RoadVolume> loadVolumeData(String fileName) throws FileNotFoundException, ParseException, NumberFormatException {

        ArrayList<RoadVolume> volumeList = new ArrayList<>();

        Scanner fileScnr = new Scanner(new File(fileName));

        // Format used to parse volume dates
        SimpleDateFormat volumeDateFormat = new SimpleDateFormat("MM/dd/yy");
        volumeDateFormat.setLenient(false); // Reject invalid dates for ParseException e

        // Skips the header line
        if (fileScnr.hasNextLine()) {
            fileScnr.nextLine();
        }

        while (fileScnr.hasNextLine()) {

            // Reads and stores next line
            String line = fileScnr.nextLine().trim();

            // Skips the current line if it's empty
            if(line.isEmpty()) {
                continue;
            }

            // Splits the CSV line
            String[] parts = line.split(",");

            // Create RoadVolume object
            RoadVolume volume = new RoadVolume(volumeDateFormat.parse(parts[0].trim()), parts[1].trim(), Integer.parseInt(parts[2].trim()), Integer.parseInt(parts[3].trim()), Integer.parseInt(parts[4].trim()), Integer.parseInt(parts[5].trim()));

            volumeList.add(volume);
        }

        fileScnr.close();

        return volumeList;
    }

    /**
     * Reads the speed data file and stores each row in a RoadSpeed object.
     *
     * @param fileName the name or path of the speed data file
     * @return an ArrayList of RoadSpeed objects
     * @throws FileNotFoundException if the file cannot be found
     * @throws ParseException if a date cannot be parsed
     * @throws NumberFormatException if a numeric value cannot be parsed
     */
    public ArrayList<RoadSpeed> loadSpeedData(String fileName) throws FileNotFoundException, ParseException, NumberFormatException {

        ArrayList<RoadSpeed> speedList = new ArrayList<>();
        Scanner fileScnr = new Scanner(new File(fileName));

        SimpleDateFormat speedDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        speedDateFormat.setLenient(false); // reject invalid dates to for ParseException e

        // Skip header
        if (fileScnr.hasNextLine()) {
            fileScnr.nextLine();
        }

        while (fileScnr.hasNextLine()) {
            String line = fileScnr.nextLine().trim();

            if(line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");

            RoadSpeed speed = new RoadSpeed(speedDateFormat.parse(parts[0].trim()), parts[1].trim(), Double.parseDouble(parts[2].trim()), Double.parseDouble(parts[3].trim()));

            speedList.add(speed);
        }

        fileScnr.close();
        return speedList;
    }

    /**
     * Writes the road section data to the output CSV file.
     *
     * @param sectionList the list of RoadSection objects to write
     * @throws FileNotFoundException if the output file cannot be created
     */
    public void writeRoadSectionData(ArrayList<RoadSection> sectionList) throws FileNotFoundException {

        // Create output file
        PrintWriter output = new PrintWriter("Road_Section_Data.csv");

        // Writes the header line
        output.println("Date,Time,Volume_Sensor_2003,Volume_Sensor_2004,Volume_Sensor_2005,Volume_Sensor_2006,Speed_Sensor_2282,Speed_Sensor_2293,Volume_Total,Volume_Avg,Speed_Avg");

        // Loop to write each road section inside output file
        for(int i = 0; i <sectionList.size(); i++) {
            RoadSection section = sectionList.get(i);
            output.println(section.getFileData());
        }

        // Close output writer
        output.close();
    }
}
