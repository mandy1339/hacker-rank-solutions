import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the toys function below.
    static int toys(int[] toys) {
        // Sort the array
        Arrays.sort(toys);

        // initialize counter
        int count = 1;

        // initialize a min weight temp holder
        int minW = toys[0];

        // loop through the array
        // every time you find an item with weight more than 4 over the previous minW, 
        // count++ and reset minW to current
        for (int i = 0; i < toys.length; i++) {
            if (toys[i] - minW > 4) {
                count++;
                minW = toys[i];
            }
        }
        return count;
    }

    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] w = new int[n];

        String[] wItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int wItem = Integer.parseInt(wItems[i]);
            w[i] = wItem;
        }

        int result = toys(w);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
