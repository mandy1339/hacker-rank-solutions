import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        char[] a = A.toCharArray();
        for(int i = 0; i < (int)(a.length/2)-1; i++) {
            char temp = a[i];
            a[i] = a[a.length-1-i];
            a[a.length-1-i] = temp;
        }
        String reversed = new String(a);
        if(A.equals(reversed)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}




