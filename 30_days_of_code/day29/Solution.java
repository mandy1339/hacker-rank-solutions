import java.util.*;

public class Solution {
	public static void main(String [] args) {
		// Declare variables
		Scanner scan = new Scanner(System.in);
		int t = 0;
		ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> pairs = new ArrayList<AbstractMap.SimpleEntry<Integer, Integer>>();
		// The previous variable pairs is an arrayList of pairs to store the pairs of n, k from System.in


		// 1 Scan T
		t = scan.nextInt();


		// 2 Scan N, K pair T times
		for(int i = 0; i < t; i++) {
			int n = scan.nextInt();
			int k = scan.nextInt();
			// Create a pair with the 2 values (n, k)
			AbstractMap.SimpleEntry<Integer, Integer> tempPair = new AbstractMap.SimpleEntry<Integer, Integer>(n, k);
			// Push the pair into the ArrayList pairs
			pairs.add(tempPair);
		}


		// 3 Make S (arrayList {1, 2, 3, 4, .. ,N}
		// For every pair, make an arrayList S,
		for (AbstractMap.SimpleEntry<Integer, Integer> pair: pairs) {
			ArrayList<Integer>results = new ArrayList<Integer>();
			//System.out.println(pair.toString());
			ArrayList<Integer> s = new ArrayList<Integer>();
			int n = pair.getKey();
			int k = pair.getValue();
			for(int i = 1; i <= n; i++) {		// making s with this loop
				s.add(i);
			}

			// 4 Double loop logic
			for(int i = 0; i < n; i++) {
				for(int j = i + 1; j <= n; j++) {
					if((i & j) < k) {
						results.add(i & j);
					}
				}
			}


			// 5 Print results.max
			System.out.println(Collections.max(results));
		}
	}
}