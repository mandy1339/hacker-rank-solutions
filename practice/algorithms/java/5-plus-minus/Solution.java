import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();
        ArrayList<Integer> zer = new ArrayList<Integer>();
        int n = 0;
        Scanner scan = new Scanner(System.in);
        
        n = scan.nextInt();
        for(int i = 0; i < n; i++){
            int temp = scan.nextInt();
            if(temp == 0)
                zer.add(temp);
            else if(temp > 0)
                pos.add(temp);
            else
                neg.add(temp);
        }
        double posRatio = (double)pos.size() / (double)n;
        System.out.println(posRatio);
        double negRatio = (double)neg.size() / (double)n;
        System.out.println(negRatio);
        double zerRatio = (double)zer.size() / (double)n;
        System.out.println(zerRatio);
        
    }
}
