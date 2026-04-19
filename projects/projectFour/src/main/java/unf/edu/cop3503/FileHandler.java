package unf.edu.cop3503;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileHandler{
    private String surveyFile;
    private FileWriter fileOutput;
    private PrintWriter printWriter;

    public FileHandler() {
        surveyFile = "survey_results.csv";
        try{
            // Set FileWriter append state = false to overwrite data
            fileOutput = new FileWriter(surveyFile, false);
            printWriter = new PrintWriter(fileOutput);

            printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
            printWriter.close();
            fileOutput.close();
        }
        catch(IOException e){
            System.out.println("Error writing file");
        }
    }

    public void writeResults(String surveyData){
        try(FileWriter fileOutput = new FileWriter(surveyFile, true)){
            printWriter = new PrintWriter(fileOutput);

            printWriter.println(surveyData);
            printWriter.close();

        }
        catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}