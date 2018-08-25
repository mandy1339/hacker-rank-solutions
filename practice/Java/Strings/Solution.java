import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        short sum = (short) (A.length() + B.length());
        String isGreater = (A.compareTo(B) < 1) ? "No" : "Yes";
        String line3 = A.substring(0,1).toUpperCase() + A.substring(1,A.length())
                + " " + B.substring(0,1).toUpperCase() + B.substring(1,B.length());
        
        System.out.println(sum);
        System.out.println(isGreater);
        System.out.println(line3);
    }
}
