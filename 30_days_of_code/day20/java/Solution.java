import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        // Write Your Code Here
        int end = a.length - 1;
        int temp = 0;
        int swapCt = 0;
        // bubble here
        while(end > 0) {
            for(int trav = 0; trav < end; trav++) {
                if(a[trav] > a[trav + 1]) {
                    // swap
                    temp = a[trav];
                    a[trav] = a[trav + 1];
                    a[trav + 1] = temp;
                    swapCt++;
                }
            }
            end--;
        }
        
        System.out.println("Array is sorted in " + swapCt + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }
}

