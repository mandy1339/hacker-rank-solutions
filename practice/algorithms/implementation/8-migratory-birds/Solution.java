import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int migratoryBirds(int n, int[] ar) {
        // Complete this function
        int [] tfq = {0, 0, 0, 0, 0, 0};
        for(int i = 0; i < ar.length; i++) {
            tfq[ar[i]]++;
        }
        int max = 0;
        for(int i = 1; i < 6; i++) {
            if(tfq[i] > max) {
                max = tfq[i];
            }
        }
        
        ArrayList<Integer> all = new ArrayList<Integer>();
        for(int i = 1; i < 6; i++) {
            if(tfq[i] == max) {
                all.add(i);
            }
        }
        return all.get(0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}

