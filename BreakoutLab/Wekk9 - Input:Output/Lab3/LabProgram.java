import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class LabProgram {
   public static void main(String[] args) throws IOException {
      Scanner scnr = new Scanner(System.in);

      ArrayList<String> movieTimes = new ArrayList<String>();
      ArrayList<String> movieTitles = new ArrayList<String>();
      ArrayList<String> movieRatings = new ArrayList<String>();

      String inputFile = scnr.nextLine();
      File myFile = new File(inputFile);

      try (Scanner myReader = new Scanner(myFile)) {
         while (myReader.hasNextLine()) {
            String singleLine = myReader.nextLine();

            String[] lineParts = singleLine.split(",", 3);
            if(movieTitles.contains(lineParts[1])) {
               int movieNameIndex = movieTitles.indexOf(lineParts[1]);
               String time = movieTimes.get(movieNameIndex);
               time += " " + lineParts[0];
               movieTimes.set(movieNameIndex, time);
            } else if (lineParts.length == 3) {
               movieTimes.add(lineParts[0]);
               movieTitles.add(lineParts[1]);
               movieRatings.add(lineParts[2]);
            }

         }
      } catch (IOException e) {
         System.out.println("Error reading file.");
      }

      for (int i = 0; i < movieTitles.toArray().length; i++) {
         System.out.printf("%-44.44s", movieTitles.get(i));
         System.out.print(" | ");
         System.out.printf("%5s", movieRatings.get(i));
         System.out.print(" | ");
         System.out.println(movieTimes.get(i));
      }
   }
}
