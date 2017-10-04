import java.util.*;
public class Solution {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		int amount = scan.nextInt();
		int m = scan.nextInt();
		long [] coins = new long[m];
		for(int i = 0; i < m; i++) {
			coins[i] = scan.nextLong();
		}
		long[][] results = new long[amount + 1][m + 1];			// Results[][] array to memoize solutions to subproblems
		for(long[] row : results) {						// Fill results with -1
			Arrays.fill(row, -1);
		}
		System.out.println(tSplit(coins, m-1,  amount, results));
	}

	public static long tSplit(long[] coins, int m, int amount, long[][] results) {
		if(amount == 0)
			return 1; 														// Base case: Change goes even
		if(m < 0)
			return 0;
		if(amount < coins[m]){										// If can't keep going down taking off the same denomination, then go to the right (next denomination)
			if(results[amount][m] > 0) {									// If Solution is memoized get it from memory
				return results[amount][m];
			}
			else {															// Else compute it and then memoize it
				long res = tSplit(coins, m-1, amount, results);
				results[amount][m] = res;
				return res;
			}
		}
		else{														// Else (can keep taking off the same denomination) go down (same) and also to the right (next)
			if(results[amount][m] > 0) {									// If Solution is memoized get it from memory
				return results[amount][m];
			}
			else {															// Else compute it and then memoize it
				long res = tSplit(coins, m, amount - (int)coins[m], results) + tSplit(coins, m-1, amount, results);
				results[amount][m] = res;
				return res;
			}
		}
	}
}


//Scanner scan = new Scanner(System.in);
//int amount = scan.nextInt();
//int m = scan.nextInt();
//int [] coins = new int[m];
//for(int i = 0; i < m; i++) {
//	m[0] = scan.nextInt()
//}

//	Sample input
//	10 4
//	2 5 3 6

//	Sample output
//	5
// 	There are 5 ways to make change for n = 10 units using coins of 2, 5, 3, 6