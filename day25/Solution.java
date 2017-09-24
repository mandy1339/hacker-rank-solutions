import java.util.*;

public class Solution {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);		// make scanner
		LinkedList<String> results = new LinkedList<String>();	// queue for results
		int numIns = scan.nextInt();				// find out num of inputs
		for(int i = 0; i < numIns; i++) {			// scan every input
			int greenNumber = scan.nextInt();
			results.add(primeFinder(greenNumber));
		}
		for(int i = 0; i < numIns; i++) {			// scan every input
			System.out.println(results.poll());
		}
			

	}

	public static String primeFinder(int n) {
		int countChecks = 0;		

		if(n <= 1) {
			return "Not prime";
		}
		
		if(n == 2) {
			return "Prime";
		}

		if(n % 2 == 0) {
			return "Not prime";
		}

		for(int i = 3; i <= (int)Math.sqrt(n); i+=2) {
			countChecks ++;
			if(n % i == 0) {
				return "Not prime performed " + countChecks + " checks";
			}
		}
		
		return "Prime     performed " + countChecks + " checks";
	}
}
