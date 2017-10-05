import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apples = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apples[apple_i] = in.nextInt();
        }
        int[] oranges = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            oranges[orange_i] = in.nextInt();
        }
        int ctApp = 0;
        int ctOj = 0;

        // ALG
        for(int apple : apples) {
            if(apple + a >= s && apple + a <= t) {
                ctApp++;
            }e
        }
        for(int oj: oranges) {
            if(oj + b <= t && oj + b >= s) {
                ctOj++;
            }
        }
        System.out.println(ctApp);
        System.out.println(ctOj);
    }
}




/*


        7 11
        5 15
        3 2
        -2 2 1
        5 -6



*/