import java.util.*;

public class GVDie implements Comparable {
   private int myValue; 
   private Random rand;
   
   public GVDie() {      
      // set default values
      myValue = (int) (Math.random()*6)+1;      
      rand = new Random();
   }

   public void roll () {
       myValue = rand.nextInt(6) + 1;       
   }
   
   public int getValue() {
       return myValue;
   }
   
      
   // set the random number generator seed for testing
   public void setSeed(int seed) {
       rand.setSeed(seed);
   
   }
   
   // allows dice to be compared if necessary
   public int compareTo(Object o) {
       GVDie d = (GVDie) o;
       return getValue() - d.getValue();
   } 
    
}