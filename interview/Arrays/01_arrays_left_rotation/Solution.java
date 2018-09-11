import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int rk = k % n;
        int [] givenArray = new int [n];
        
        // Scan Given Array
        for(int i = 0; i < n; i++) {
            givenArray[i] = scan.nextInt();
        }
        int index = n - rk;
        int [] result = new int [n];
        
        // Load Values into Result
        for(int i = 0; i < n; i++) {
            if(index == n) {
                index = 0;
            }
            result[index] = givenArray[i];
            index ++;
        }
        
        // Print Result
        for(int i : result) {
            System.out.print(i + " ");
        }
        
    }
}

