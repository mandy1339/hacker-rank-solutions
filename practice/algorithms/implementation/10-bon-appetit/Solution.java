import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int bonAppetit(int n, int k, int b, int[] ar) {
        // Complete this function
        int annaTotal = 0;
        for(int i = 0; i < ar.length; i++) {
            if(i != k) {
                annaTotal += ar[i];
            }
        }
        annaTotal = annaTotal / 2;
        return b - annaTotal;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();                   // Read n (items)
        int k = in.nextInt();                   // Read k (skipped item)
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){    
            ar[ar_i] = in.nextInt();            // Read items into ar
        }
        int b = in.nextInt();                   // Read b (Anna Charged)
        int result = bonAppetit(n, k, b, ar);   // Call bonAppetit()
        if(result == 0) {
            System.out.println("Bon Appetit");
        }
        else {
            System.out.println(result);    
        }
        
    }
}

