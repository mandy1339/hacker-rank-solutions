import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int sockMerchant(int n, int[] ar) {
        // Complete this function
        int [] fqTable = new int [101];
        Arrays.fill(fqTable, 0);
        for(int i = 0; i < ar.length; i++) {
            fqTable[ar[i]]++;
        }
        int count = 0;
        for(int i = 0; i < fqTable.length; i++) {
            count += fqTable[i] / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}

