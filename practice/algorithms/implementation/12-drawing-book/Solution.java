import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int solve(int n, int p){
        // Complete this function
        // 1. Calculate left to right
        int l2r = (p / 2);
        
        int r2l = 0;
        if(n % 2 == 0) {
            // 2. Calculate right to left (even case)    
            r2l = ((n - p) + 1) / 2;
        }
        else {
            // 3. Calculate right to left (odd case)
            r2l = (n - p) / 2;
        }
        return Math.min(l2r, r2l);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();                   // Read n (num pages)
        int p = in.nextInt();                   // Read p (page)
        int result = solve(n, p);               // Call solve()
        System.out.println(result);             // Print result returned from solve()
    }
}

