import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int deletions = 0;
        char[] charArrA = a.toCharArray();
        char[] charArrB = b.toCharArray();
        Map<Character, Integer> mapA = new HashMap<Character, Integer>();
        Map<Character, Integer> mapB = new HashMap<Character, Integer>();
        Set<Character> charSet = new HashSet<Character>();
        
        
        for (char c : charArrA) {
            charSet.add(c);
            if (mapA.containsKey(c) != true) {
                mapA.put(c, 1);
            }
            else {
                mapA.put(c, mapA.get(c) + 1);
            }
        }
        
        for (char c : charArrB) {
            charSet.add(c);
            if (mapB.containsKey(c) != true) {
                mapB.put(c, 1);
            }
            else {
                mapB.put(c, mapB.get(c) + 1);
            }
        }
        
        for (Character c : charSet) {
            int aCount = mapA.containsKey(c) ? mapA.get(c) : 0;
            int bCount = mapB.containsKey(c) ? mapB.get(c) : 0;
            deletions += Math.abs(aCount - bCount);
        }
        
        return deletions;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

