import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        // create a hashmap int->int that maps each flavCost to its index
        Map<Integer, Integer> flavMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < cost.length; i++) {
            flavMap.put(cost[i], i+1);
        }
        
        // iterate through array. For each item, find its complement. Stop when you find it
        for (int i = 0; i < cost.length; i++) {
            int complement = money - cost[i];
            if (flavMap.containsKey(complement) && flavMap.get(complement) != i+1) {
                int smaller = i+1 <= flavMap.get(complement)? i+1 : flavMap.get(complement);
                int greater = i+1 >= flavMap.get(complement)? i+1 : flavMap.get(complement);
                System.out.println(smaller + " " + greater);
                break;
            }
            
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}

