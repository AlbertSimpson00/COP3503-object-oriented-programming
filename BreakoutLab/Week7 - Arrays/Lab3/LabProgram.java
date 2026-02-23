import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      /* Type your code here. */
      Scanner scnr = new Scanner(System.in);
      int maxInts = scnr.nextInt();

      int[] firstListInts = new int[20];
      for (int i = 0; i < maxInts; i++) {
         int value = scnr.nextInt();
         firstListInts[i] = value;
      }
      int[] secListInts = new int[20];
      for (int i = 0; i < maxInts; i++) {
         int value = scnr.nextInt();
         secListInts[i] = value;
      }

      int output = 0;
      for (int i = 0; i < maxInts; i++) {
         output = output + (firstListInts[i] * secListInts[i]);
      }
      System.out.println(output);
   }
}
