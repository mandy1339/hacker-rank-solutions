import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        // Make variables to hold large sums
        long max = 0;
        long min = 0;
        
        // Sort the array
        Arrays.sort(arr);
        
        // Calculate min and max
        max = (long)arr[1] + (long)arr[2] + (long)arr[3] + (long)arr[4];
        min = (long)arr[0] + (long)arr[1] + (long)arr[2] + (long)arr[3];
        
        // Print the sum of the 1st 4
        System.out.print(min);
        
        // Print the sum of the last 4
        System.out.print(" " + max);
    }
}
