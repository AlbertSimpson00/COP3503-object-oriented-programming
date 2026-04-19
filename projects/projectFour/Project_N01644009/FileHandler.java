package unf.edu.cop3503;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * FileHandler class
 *
 * This class handles writing survey data to a CSV file.
 * When the object is created, it initializes the file
 * and writes the column headers. Each time the user
 * submits the form, the data is appended to the file.
 *
 * @author Albert Simpson
 * @version Project 4
 */
public class FileHandler{

    // Name of the file where survey results are stored
    private String surveyFile;

    // File writing objects used to write data
    private FileWriter fileOutput;
    private PrintWriter printWriter;

    /**
     * Default constructor.
     *
     * This constructor creates the CSV file and writes
     * the header row. Existing contents are overwritten
     * when the program starts.
     */
    public FileHandler() {
        surveyFile = "survey_results.csv";
        try{
            // Create FileWriter and set append state = false to overwrite data
            fileOutput = new FileWriter(surveyFile, false);

            // Create PrintWriter for writing text
            printWriter = new PrintWriter(fileOutput);

            // Write column headers
            printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");

            // Close file resources to prevent bugs and leakage
            printWriter.close();
            fileOutput.close();
        }
        catch(IOException e){
            System.out.println("Error writing file");
        }
    }

    /**
     * Writes survey data to the CSV file.
     *
     * This method appends new survey results
     * as a new row in the file.
     *
     * @param surveyData comma-separated survey data
     */
    public void writeResults(String surveyData){

        // Open FileWriter in append mode
        try(FileWriter fileOutput = new FileWriter(surveyFile, true)){

            // Create PrintWriter
            printWriter = new PrintWriter(fileOutput);

            // Write survey data to file
            printWriter.println(surveyData);

            // Close writer
            printWriter.close();

        }
        catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}