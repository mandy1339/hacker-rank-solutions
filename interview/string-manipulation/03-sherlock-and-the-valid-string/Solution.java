import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        if (s.length() == 1) {
            return "YES";
        }
        boolean oneMoreChance = true;
        Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            if (freqMap.containsKey(c) != true) {
                freqMap.put(c, 1);
            }
            else {
                freqMap.put(c, freqMap.get(c) + 1);
            }
        }
        
        
        Collection<Integer> col = freqMap.values();
        Integer[] vals = new Integer[col.size()];
        vals = col.toArray(vals);
        
        int freq;
        if (vals[0] - vals[1] == 1) {
            freq = vals[1];
            oneMoreChance = false;
        }
        else if (vals[1] - vals[0] == 1) {
            freq = vals[0];
            oneMoreChance = false;
        }
        else if (vals[0] == 1) {
            oneMoreChance = false;
            freq = vals[1];
        }
        else if (Math.abs(vals[1] - vals[0]) > 1) {
            return "NO";
        }else {
            freq = vals[0];
        }
        
        if (vals.length > 2) {
            for (int i = 2; i < vals.length; i++) {
                if (vals[i] == 1 && oneMoreChance != true) {
                    return "NO";
                }
                if (vals[i] == 1 && oneMoreChance == true) {
                    oneMoreChance = false;
                    continue;
                }
                if (vals[i] - freq > 1) {
                    return "NO";
                }
                if (vals[i] - freq == 1 && oneMoreChance != true) {
                    return "NO";
                }
                if (vals[i] - freq == 1 && oneMoreChance == true) {
                    oneMoreChance = false;
                }
                if (vals[i] - freq < 0) {
                    return "NO";
                }
            }    
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

