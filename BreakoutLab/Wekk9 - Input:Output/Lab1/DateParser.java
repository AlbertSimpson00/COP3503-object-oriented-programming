import java.util.Scanner;

public class DateParser {
   public static int getMonthAsInt(String monthString) {
      int monthInt;
      
      // Java switch/case statement                                                                
      switch (monthString) {
         case "January": 
            monthInt = 1; 
            break;
         case "February": 
            monthInt = 2; 
            break;
         case "March": 
            monthInt = 3; 
            break;
         case "April": 
            monthInt = 4; 
            break;
         case "May": 
            monthInt = 5; 
            break;
         case "June": 
            monthInt = 6; 
            break;
         case "July": 
            monthInt = 7; 
            break;
         case "August": 
            monthInt = 8; 
            break;
         case "September": 
            monthInt = 9; 
            break;
         case "October": 
            monthInt = 10; 
            break;
         case "November": 
            monthInt = 11; 
            break;
         case "December": 
            monthInt = 12; 
            break;
         default: 
            monthInt = 0;
      }
      
      return monthInt;
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int printMonth = 0;
      String printDate = "";
      String printYear = "";
      int checkSpace1 = 0;
      int checkComma = 0;

      int startIndex = 0;
      int endIndex;

      do {
         String inputDate = scnr.nextLine();
         if (inputDate.equals("-1")) {
            break;
         }
         for (int i = 0; i < inputDate.length(); i++) {
            if (inputDate.charAt(i) == ' ') {
               endIndex = i;
               // For Year
               if (checkSpace1 == 1 && checkComma == 1) {
                  printYear = inputDate.substring(endIndex).trim();
               }
               // For month
               if (getMonthAsInt(inputDate.substring(startIndex, endIndex)) != 0 && checkSpace1 == 0) {
                  printMonth = getMonthAsInt(inputDate.substring(startIndex, endIndex));
                  checkSpace1 = 1;
               }
               startIndex = i;
            }

            if (inputDate.charAt(i) == ',') { // Date
               endIndex = i;
               checkComma = 1;
               // For date
               if (Character.isDigit(inputDate.charAt(i-1)) || Character.isDigit(inputDate.charAt(i)) && checkSpace1 == 1) {
                  printDate = inputDate.substring(startIndex, endIndex).trim();
               }
               startIndex = i;
            }
         }
         if (checkSpace1 != 1 || checkComma != 1) {

            startIndex = 0;
            printDate = "";
            printYear = "";
            printMonth = 0;
            checkSpace1 = 0;
            checkComma = 0;
            continue;
         }
         System.out.println(printMonth + "/" + printDate + "/" + printYear);

         startIndex = 0;
         printDate = "";
         printYear = "";
         printMonth = 0;
         checkSpace1 = 0;
         checkComma = 0;
      } while (0x0 <3);
   }
}
