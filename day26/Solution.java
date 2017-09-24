import java.util.*;

public class Solution {
    public static void main(String [] args) {
        // Get the inputs
        int day1, month1, year1, day2, month2, year2;
        Scanner scan = new Scanner(System.in);
        day1 = scan.nextInt();
        month1 = scan.nextInt();
        year1 = scan.nextInt(); 
        day2 = scan.nextInt();
        month2 = scan.nextInt();
        year2 = scan.nextInt(); 
    
        // Next year late
        if(year1 > year2) {
            System.out.println(10000);
        }
        // Same year
        else if(year1 == year2) 
        {
            // Months late
            if(month1 > month2) 
            {
                System.out.println(500 * (month1 - month2));
            }   
            // Same month
            else if(month1 == month2) 
            {
                // Days late
                if(day1 > day2) 
                {
                    System.out.println(15 * (day1 - day2));
                }
                else    // Days early or same day
                {
                    System.out.println(0);
                }
            }
            else    // Month/s early
            {
                System.out.println(0);
            }
        }
        else    // Year/s early
        {
            System.out.println(0);
        }
          
    }   
}
