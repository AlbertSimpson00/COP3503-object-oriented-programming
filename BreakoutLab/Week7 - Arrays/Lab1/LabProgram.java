import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      /* Type your code here. */
      Scanner scnr = new Scanner(System.in);
      int inputWords = scnr.nextInt();
      String[] words = new String[inputWords];
      for (int i = 0; i < inputWords; i++) {
         words[i] = scnr.next();
      }

      char matchingChar = scnr.next().charAt(0);

      for (int i = 0; i < inputWords; i++) {
         if (words[i].contains(String.valueOf(matchingChar))) {
            System.out.print(words[i] + ",");
         }
      }
      System.out.println();
   }
}
