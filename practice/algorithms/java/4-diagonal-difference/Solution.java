import java.util.*;

public class Solution{
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		int sum1 = 0;
		int sum2 = 0;
		int n = 0;
		int[][] mat;		

		n = scan.nextInt();
		mat = new int[n][n];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				mat[i][j] = scan.nextInt();
			}
		}
				
		for(int i = 0; i < n; i++) {
			sum1 += mat[i][i];
			sum2 += mat[i][(n-1)-i];
		}
		System.out.println(Math.abs(sum1 - sum2));
	}
}
