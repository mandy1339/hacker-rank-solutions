import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        BigInteger t1 = scan.nextBigInteger();
        BigInteger t2 = scan.nextBigInteger();
        BigInteger n = scan.nextBigInteger();
        BigInteger[] results = new BigInteger[1000];
        System.out.println(fib3(t1, t2, n, results));


    }
    public static BigInteger fib3(BigInteger t1, BigInteger t2, BigInteger n, BigInteger[] results) {
        // Base cases
        if(n.equals(BigInteger.valueOf(1))) {
            return t1;
        }
        if(n.equals(BigInteger.valueOf(2))) {
            return t2;
        }

        // Non base cases
        BigInteger sum = BigInteger.valueOf(0);
        BigInteger fib1 = fib3(t1, t2, n.subtract(BigInteger.valueOf(1)), results);
        BigInteger fib2 = fib3(t1, t2, n.subtract(BigInteger.valueOf(2)), results);
        sum = fib2.add(fib1.multiply(fib1));

        return sum;
    }
}
