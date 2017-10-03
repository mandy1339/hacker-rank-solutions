import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int v = scan.nextInt();
        int n = scan.nextInt();
        int [] ar = new int [n];
        for(int i = 0; i < n; i++) {
            ar[i] = scan.nextInt();
        }
        
        // Find v in the array and return its index
        for(int i = 0; i < n; i++) {
            if(ar[i] == v) {
                System.out.println(i);
                break;
            }            
        }
    }
}
