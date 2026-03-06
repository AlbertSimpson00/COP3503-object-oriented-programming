import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class LabProgram {
   public static void main(String[] args) throws IOException {
      Scanner scnr = new Scanner(System.in);

      /* TODO: Declare any necessary variables here. */
      String fileName = scnr.nextLine();
      Scanner fileScanner = null;

      double mid1Total = 0;
      double mid2Total = 0;
      double finalTotal = 0;
      int counter = 0;
      
      /* TODO: Read a file name from the user and read the tsv file here. */
      try {
         fileScanner = new Scanner(new FileInputStream(fileName));
      } catch (Exception e) {
         System.out.println("Error reading file.");
         return;
      }
      
      /* TODO: Compute student grades and exam averages, then output results to a text file here. */

      try {
         PrintWriter out = new PrintWriter(new FileOutputStream("report.txt"));

         while (fileScanner.hasNext()) {
            String lastName = fileScanner.next();
            String firstName = fileScanner.next();
            int mid1 = fileScanner.nextInt();
            int mid2 = fileScanner.nextInt();
            int finalTest = fileScanner.nextInt();

            double testAvg = (mid1 + mid2 + finalTest) / 3.0;

            char finalGrade;

            if(testAvg >= 90) {
               finalGrade = 'A';
            } else if (testAvg >= 80) {
               finalGrade = 'B';
            } else if (testAvg >= 70) {
               finalGrade = 'C';
            } else if (testAvg >= 60) {
               finalGrade = 'D';
            } else {
               finalGrade = 'F';
            }

            out.println(lastName + "\t" + firstName + "\t" + mid1 + "\t" + mid2 + "\t" + finalTest + "\t" + finalGrade);

            mid1Total += mid1;
            mid2Total += mid2;
            finalTotal += finalTest;
            counter++;
         }

         // Print avgs
         double mid1Avg = mid1Total / counter;
         double mid2Avg = mid2Total / counter;
         double finAvg = finalTotal / counter;
         out.printf("\nAverages: Midterm1 %.2f, Midterm2 %.2f, Final %.2f\n", mid1Avg, mid2Avg, finAvg);

         out.close();
      } catch (IOException e) {
         System.out.println("Error writing file.");
      }
      fileScanner.close();
   }
}