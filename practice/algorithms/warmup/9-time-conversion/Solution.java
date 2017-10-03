import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    // Takes in a 07:05:45PM Shoots out a 19:05:45
    static String timeConversion(String s) {
        // Complete this function
        String regex = "\\d\\d";
        String result = ""; 
        String target = s;
        int first2 = 0;
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(target);
        if(m.find()) {
            result += m.group();
            first2 = Integer.parseInt(result);
        }
        while(m.find()) {
            result += ":" + m.group();
        }
        if(s.substring(s.length() - 2, s.length()).equals("PM") && first2 != 12) {
            first2 += 12; 
            String result2 = "" + first2 + result.substring(2, result.length());
            return result2; 
        }
        if(s.substring(s.length() - 2, s.length()).equals("AM") && first2 == 12) {
            first2 = 0; 
            String result2 = "" + first2 + first2 + result.substring(2, result.length());
            return result2; 
        }
        return result;  
    }   

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);    
        String s = in.next();                   // Read s
        String result = timeConversion(s);      // Call timeConversion
        System.out.println(result);             // Print result
    }   
} 
