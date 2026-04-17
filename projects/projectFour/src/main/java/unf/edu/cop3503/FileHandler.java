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
            FileWriter fw = new FileWriter(surveyFile, false);
            PrintWriter pw = new PrintWriter(fw);

            pw.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
            pw.close();
            fw.close();
        }
        catch(IOException e){
            System.out.println("Error writing file");
        }
    }

    public void writeResults(String surveyData){
        // surveyFile = "survey_results.csv";
        try(FileWriter fw = new FileWriter(surveyFile, true)){
            PrintWriter pw = new PrintWriter(fw);

            pw.println(surveyData);
            pw.close();
            fw.close();
        }
        catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}