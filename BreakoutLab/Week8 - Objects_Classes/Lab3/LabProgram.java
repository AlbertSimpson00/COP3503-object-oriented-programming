import java.util.Scanner;

public class LabProgram {
   public static int rollSpecificTimes(GVDie d, int rolls){
      
      int sum = 0;

      for (int i = 0; i < rolls; i++) {
         d.roll();
         sum += d.getValue();
      }

      return sum;
   }
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      GVDie die = new GVDie();   // Create a GVDie object
      die.setSeed(15);   // Set the GVDie object with seed value 15
      int rolls;
      int total;
      int repeats;
      
      rolls = scnr.nextInt();
      total = rollSpecificTimes(die, rolls);   // Call rollSpecificTimes() and return the total.
      System.out.println(rolls + " rolls return a total of " + total + ".");
   }
}
