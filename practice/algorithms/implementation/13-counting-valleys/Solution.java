import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int stepAmt = scan.nextInt();
        String stepsStr = scan.next();
        char [] steps = stepsStr.toCharArray();
        int height = 0;
        int vallCt = 0;
        boolean vall = false;
        for(char step: steps) {
            if(step == 'U') { height ++; }
            if(step == 'D') { height --; }
            if(vall == false && height < 0) { vall = true; }
            if(vall == true && height == 0) {
                vall = false;
                vallCt ++;
            }
        }
        System.out.println(vallCt);
    }
}
