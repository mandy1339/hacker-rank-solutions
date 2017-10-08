import java.util.*;

public class Solution {
    public static int getMoneySpent(int[] kAr, int[] dAr, int s, int n, int m) {
        Arrays.sort(kAr);
        Arrays.sort(dAr);
        reverse(kAr);
        reverse(dAr);
        int max = 0;

        // 1. Scan every keyboard with every drive (keep max)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int sumPair = kAr[i] + dAr[j];
                if(sumPair <= s && sumPair > max) {
                    max = sumPair;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] drives = new int[m];
        for(int drives_i=0; drives_i < m; drives_i++){
            drives[drives_i] = in.nextInt();
        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, s, n, m);
        if(moneySpent != 0) { System.out.println(moneySpent); }
        else { System.out.println(-1); }
    }


    public static void reverse(int [] ar) {
        int start = 0;
        int end = ar.length - 1;
        while(start <= end) {
            int temp = ar[start];
            ar[start] = ar[end];
            ar[end] = temp;
            start ++;
            end --;
        }
    }
}
