import java.util.*;
import java.util.regex.*;

public class Solution {
	public static void main(String [] args) {
		ArrayList<String> results = new ArrayList<String>();	// container for results
		String regExStr ="^.+@gmail.com$";						// regEx
		
		Scanner scan = new Scanner(System.in);					// set up scanner
		int n = scan.nextInt();									// scan n
		scan.nextLine();										// advance scanner to next line
	
		Pattern p = Pattern.compile(regExStr);					// create a pattern with the regex
		for(int i = 0; i < n; i++) {
			Matcher m =	p.matcher(scan.nextLine());
			if(m.find()) {
				results.add(m.group());
			}
		}

		// create new arraylist
		ArrayList<String> names = new ArrayList<String>();

		for(int i = 0; i < results.size(); i++) {
			String [] name = results.get(i).split(" ");
			names.add(name[0]);
		}
		// sort the arraylist with names
		Collections.sort(names);
		for(int i = 0; i < results.size(); i++) {
			System.out.println(names.get(i));
		}
	}
}
