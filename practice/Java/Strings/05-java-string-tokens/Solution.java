import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        String[] ar = s.split("[ !,?._'@]+");
        
        int tokens = ar.length;
        if(ar.length > 0 && ar[0].equals("")) {
            tokens--;
        }
        
        System.out.println(tokens);
        for(int i = 0; i < ar.length; i++) {
            if(i == 0 & ar[0].equals("")) {
                continue;
            }
            System.out.println(ar[i]);
        }
        
        scan.close();
    }
}


