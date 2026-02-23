import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      /* Type your code here. */
      Scanner scnr = new Scanner(System.in);
      int N = scnr.nextInt();

      int[] matrixOne = new int[N];
      for (int i = 0; i < N; i++) {
         matrixOne[i] = scnr.nextInt();
      }
      int[][] matrixTwo = new int[N][N];
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
            matrixTwo[i][j] = scnr.nextInt();
         }
      }


      int[] outputMatrix = new int[N];
      for (int i = 0; i < N; i++) {
         int sum = 0;
         for (int j = 0; j < N; j++) {
            sum = sum + (matrixOne[j] * matrixTwo[j][i]);
         }
         outputMatrix[i] = sum;
      }
      for (int val : outputMatrix) {
         System.out.print(val + " ");
      }
      System.out.println();
   }
}
