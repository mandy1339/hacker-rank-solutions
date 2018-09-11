import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
            
        
        // create result list (array int)
        int [] resultList;
        List<Integer> rawResultList= new ArrayList<Integer>(); 
        
        // create and populate frequency table for original list
        Map<Integer, Integer> origList = new HashMap<Integer, Integer>();
        for (int i : brr) {
            if (origList.containsKey(i) != true) {
                origList.put(i, 1);
            }
            else {
                origList.put(i, origList.get(i) + 1);
            }
            // TODO : Potentially optimize by storing origList.get(i) in a local variable to not search for it every time
        }
        
        // create and populate frequency table for new list
        Map<Integer, Integer> newList = new HashMap<Integer, Integer>();
        for (int i : arr) {
            if (newList.containsKey(i) != true) {
                newList.put(i, 1);
            }
            else {
                newList.put(i, newList.get(i) + 1);
            }
            // TODO : Potentially optimize by storing origList.get(i) in a local variable to not search for it every time
        }
        
        // for every item in the original list, compare to the item in the new list
        // if the new list doesn't have it or has less of it, store the item in the result list
        for (Map.Entry<Integer, Integer> e : origList.entrySet()) {
            int newCount = !newList.containsKey(e.getKey()) ? 0 : newList.get(e.getKey());    // TODO potential optimization
            if (e.getValue() > newCount) {
                rawResultList.add(e.getKey());
            }
        }
        
        resultList = new int[rawResultList.size()];
        for (int i = 0; i < rawResultList.size(); i ++) {
            resultList[i] = rawResultList.get(i);
        }
        
        // sort the result list
        Arrays.sort(resultList);
        
        // return the result list;
        return resultList;
    }

    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

