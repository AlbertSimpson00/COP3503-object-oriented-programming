import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      /* Type your code here. */
      Scanner scnr = new Scanner(System.in);
      int i = 0;

      int[] listInts = new int[20];
      do {
         int value = scnr.nextInt();
         if (value == -1) break;
         listInts[i] = value;
         i++;
      } while (i < listInts.length);

      int maxCount = 0;
      int maxIndex = -1;
      for (int j = 0; j < i; j++) {
         int currCount = 0;
         for(int k = 0; k < i; k++) {
            if (listInts[j] == listInts[k]) {
               currCount++;
               System.out.println(listInts[j] + " " + currCount);
            }
         }
         if (currCount > maxCount) {
            maxCount = currCount;
            maxIndex = j;
         }
      }
      System.out.print(listInts[maxIndex]);
   }
}
