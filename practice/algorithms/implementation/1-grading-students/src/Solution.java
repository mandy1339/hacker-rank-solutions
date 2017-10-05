import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] solve(int[] grades){
        // Complete this function
        for(int i = 0; i < grades.length; i++) {             // For each i (grade) in array grades
            if(grades[i] > 35) {
                if(grades[i] % 5 == 3) {
                    grades[i] += 2;
                }
                else if(grades[i] % 5 == 4) {
                    grades[i] += 1;
                }
            }
        }
        return grades;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();                           // Read n (no of students)
        int[] grades = new int[n];                      // Create an array size n
        for(int grades_i=0; grades_i < n; grades_i++){  // n times
            grades[grades_i] = in.nextInt();                // Read each i (individual grade)
        }
        int[] result = solve(grades);                   // Call mathod solve passing array grades
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
    }
}

