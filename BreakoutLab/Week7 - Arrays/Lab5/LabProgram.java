import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      /* Type your code here. */
      Scanner scnr = new Scanner(System.in);
      int N = scnr.nextInt();
      String inputLine = scnr.nextLine();

      String[] words = inputLine.split(" ");
      for (int i = 0; i < words.length; i++) {
         words[i] = words[i].trim();

      }

      for (int i = 1; i <= N; i++) {
         int counter = 0;
         for (int j = 1; j <= N; j++) {
            if (words[i].equals(words[j])) counter++;
         }
         System.out.println(words[i] + " - " + (counter));
      }
   }
}
