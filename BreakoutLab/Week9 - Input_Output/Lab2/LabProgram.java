import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class LabProgram {
   public static void main(String[] args) throws IOException {
      Scanner scnr = new Scanner(System.in);

      String fileName = scnr.nextLine();
      String fileContent = "";
      String replaced;

      /* Type your code here. */
      // Try-Catch reads and prints.
      try (FileInputStream input = new FileInputStream(fileName)) {
         int data;

         while ((data = input.read()) != -1) {
            fileContent += (char) data;
         }

         replaced = fileContent.replace("_photo.jpg", "_info.txt");

         System.out.print(replaced);

      } catch (IOException e) {
         System.out.println("Error reading file.");
      }
   }
}
