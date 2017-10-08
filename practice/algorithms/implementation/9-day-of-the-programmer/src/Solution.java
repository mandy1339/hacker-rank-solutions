import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String solve(int year){
        // Complete this function
        // 1- Prepare your vars
//        String yearStr = "" + year;
//        String last2 = yearStr.substring(2,4);
        int [] leapY = new int [12];
        int [] nonY = new int [12];
        fillYear(leapY);
        fillYear(nonY);
        leapY[1]++;                 // Add a day on february for leap year


        // 2- Compare the year to 1918
        if(year <= 1918) {
            // 3- If before use Julian
            if(year % 4 == 0){          // If mod 4 => leap
                return findDate(leapY, year);
            }
            else{
                return findDate(nonY, year);
            }
        }
        else{
            // 4- If after use Gregorian
            if(year % 400 == 0) {
                return findDate(leapY, year);
            }
            if(year % 100 != 0 && year % 4 == 0) {
                return findDate(leapY, year);
            }
            else {
                return findDate(nonY, year);
            }
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();                // Read the year
        String result = solve(year);            // Call solve()
        System.out.println(result);             // Print result returned by solve()
    }

    public static void fillYear(int [] year) {
        year[0] = 31;
        year[1] = 28;
        year[2] = 31;
        year[3] = 30;
        year[4] = 31;
        year[5] = 30;
        year[6] = 31;
        year[7] = 31;
        year[8] = 30;
        year[9] = 31;
        year[10] = 30;
        year[11] = 31;
    }


    public static String findDate(int [] yearArr, int year) {
        int d = 256;                // Days into the year
        if(year == 1918) {          // If it's the transition year, add 13 days
            d = d + 13;
        }
        int m = 0;                  // Placeholder for month
        String dString = "";
        String mString = "";
        while(d > yearArr[m]) {
            d = d - yearArr[m];
            m++;
        }

        if(d < 10) {
            dString = "0" + d;
        }
        else {
            dString = "" + d;
        }
        if(m < 10) {
            mString = "0" + (m + 1);
        }
        else {
            mString = "" + (m + 1);
        }
        return ( "" + dString + "." + mString + "." + year);
    }


}