import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        char [] charArr = s.toCharArray();
        long sLength = s.length();
        
        // case 1     n smaller than s length
        if(n < sLength)
            return countAinSubstring(charArr, n);

        
        // case 2     n greater than s length
        long totalCount = 0;
        long aCount = countAinS(charArr);
        totalCount = ((long)(n / sLength)) * aCount;
        totalCount += countAinSubstring(charArr, (int)(n % sLength));
    
        return totalCount;
    }
    public static long countAinSubstring(char[] arr, long index) {
        int count = 0;
        for (int i = 0; i < index; i++) {
            if (arr[i] == 'a')
                count++;
        }
        return count;
    }
    
    public static long countAinS(char[] arr) {
        int count = 0;
        for (char c : arr) {
            if (c == 'a') 
                count++;
        }
        return count;
    }
    
    
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

