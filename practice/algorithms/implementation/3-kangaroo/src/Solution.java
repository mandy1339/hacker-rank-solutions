import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        // Complete this function
        boolean touched = false;
        int pos1 = x1;
        int pos2 = x2;
        while(pos2 >= pos1 && touched == false) {
            pos1 += v1;
            pos2 += v2;
            if(pos1 == pos2) { touched = true; }
        }
        if(touched == true) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}




/*


0 3 4 2

YES







0 2 5 3

NO




 */
