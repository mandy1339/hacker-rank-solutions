import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
        Arrays.sort(ar);
        for(int start=0, end=ar.length - 1; start < end; start++, end--) {
            int temp = ar[start];
            ar[start] = ar[end];
            ar[end] = temp;
        }
        int max = ar[0];
        int count = 0;
        int index = 0;
        while(index < (ar.length) && ar[index] == max) {
            count++;
            index++;
        }
        return count;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();                   // Scan n
        int[] ar = new int[n];                  // Initialize array ar
        for(int ar_i = 0; ar_i < n; ar_i++){    
            ar[ar_i] = in.nextInt();            // Scan every candle
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}

