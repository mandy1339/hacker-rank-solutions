import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sp = n - 1;
        int ha = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < sp; j++) {
                System.out.print(" ");      // print spaces
            }
            for(int k = 0; k < ha; k++) {
                System.out.print("#");      // print #s
            }
            System.out.println();   // print new line
            sp--;
            ha++;
        }
    }
}
