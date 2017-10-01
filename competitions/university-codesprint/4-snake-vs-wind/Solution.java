import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char d = in.next().charAt(0);
        int x = in.nextInt();
        int y = in.nextInt();
        // Write Your Code Here
        in.close();

        ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        boolean down = false;
        boolean up = false;
        boolean right = false;
        boolean left = false;
        // 1-Make the grid
        for(int i = 0; i < n; i++) {
            grid.add(new ArrayList<Integer>(Collections.nCopies(n, 0)));
        }

        // E-Handle case e 0 n
        if(d == 'e' && x == 0 && y == n-1) {
            down = true;
           // System.out.println("case e 0 n-1");
            int time = 1;
            for(int col = n - 1; col >= 0; col--) {       // Loop n times from right to left
                // Go down case
                if(down == true) {
                    for(int i = 0; i < n; i++) {        // Loop n times going down
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                // Go up case
                if(down == false) {
                    for(int i = n - 1; i >= 0; i--) {   // Loop n times going up
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                if(down == true) {  // Change down flag so snake knows which direction it followed last
                    down = false;
                }
                else {
                    down = true;
                }

            }
        }

        // E2-Handle case e n-1 n-1
        if(d == 'e' && x == (n-1) && y == (n-1)) {
            down = false;
           // System.out.println("case e 0 n");
            int time = 1;
            for(int col = n - 1; col >= 0; col--) {       // Loop n times from right to left
                // Go down case
                if(down == true) {
                    for(int i = 0; i < n; i++) {        // Loop n times going down
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                // Go up case
                if(down == false) {
                    for(int i = n - 1; i >= 0; i--) {   // Loop n times going up
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                if(down == true) {  // Change down flag so snake knows which direction it followed last
                    down = false;
                }
                else {
                    down = true;
                }

            }
        }

        // E3-Handle case e 0 0
        if(d == 'e' && x == 0 && y == 0) {
            down = true;
         //   System.out.println("case e 0 0");
            int time = 1;                       // Start time
            // Go straight right first
            for(int i = 0; i < n; i++) {
                grid.get(0).set(i, time);
                time++;
            }
            // Then traverse
            for(int col = n - 1; col >= 0; col--) {       // Loop n times from right to left
                // Go down case
                if(down == true) {
                    for(int i = 1; i < n; i++) {        // Loop n times going down
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                // Go up case
                if(down == false) {
                    for(int i = n - 1; i >= 1; i--) {   // Loop n times going up
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                if(down == true) {  // Change down flag so snake knows which direction it followed last
                    down = false;
                }
                else {
                    down = true;
                }

            }
        }

        // E4-Handle case e n-1 0
        if(d == 'e' && x == n-1 && y == 0) {
            down = false;
          //  System.out.println("case e 0 0");
            int time = 1;                       // Start time
            // Go straight right first
            for(int i = 0; i < n; i++) {
                grid.get(n - 1).set(i, time);
                time++;
            }
            // Then traverse
            for(int col = n - 1; col >= 0; col--) {       // Loop n times from right to left
                // Go down case
                if(down == true) {
                    for(int i = 0; i < n - 1; i++) {        // Loop n times going down
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                // Go up case
                if(down == false) {
                    for(int i = n - 2; i >= 0; i--) {   // Loop n times going up
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                if(down == true) {  // Change down flag so snake knows which direction it followed last
                    down = false;
                }
                else {
                    down = true;
                }

            }
        }

        // W1-Handle case w 0 0
        if(d == 'w' && x == 0 && y == 0) {
            down = true;
            //.println("case w 0 0");
            int time = 1;                       // Start time

            // Then traverse
            for(int col = 0; col <= n - 1; col++) {       // Loop n times from left to right
                // Go down case
                if(down == true) {
                    for(int i = 0; i <= n - 1; i++) {        // Loop n times going down
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                // Go up case
                if(down == false) {
                    for(int i = n - 1; i >= 0; i--) {   // Loop n times going up
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                if(down == true) {  // Change down flag so snake knows which direction it followed last
                    down = false;
                }
                else {
                    down = true;
                }

            }
        }

        // W2-Handle case w n-1 0
        if(d == 'w' && x == n-1 && y == 0) {
            down = false;
    //            //.println("case w n-1 0");
            int time = 1;                       // Start time

            // Then traverse
            for(int col = 0; col <= n - 1; col++) {       // Loop n times from left to right
                // Go down case
                if(down == true) {
                    for(int i = 0; i <= n - 1; i++) {        // Loop n times going down
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                // Go up case
                if(down == false) {
                    for(int i = n - 1; i >= 0; i--) {   // Loop n times going up
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                if(down == true) {  // Change down flag so snake knows which direction it followed last
                    down = false;
                }
                else {
                    down = true;
                }

            }
        }

        // W3-Handle case w 0 n-1
        if(d == 'w' && x == 0 && y == (n-1)) {
            down = true;
            //.out.println("case w 0 n-1");
            int time = 1;                       // Start time

            // Go Straight left
            for(int i = n-1; i >= 0; i--) {
                grid.get(0).set(i, time);
                time++;
            }

            // Then traverse
            for(int col = 0; col <= n - 1; col++) {       // Loop n times from left to right
                // Go down case
                if(down == true) {
                    for(int i = 1; i <= n - 1; i++) {        // Loop n times going down
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                // Go up case
                if(down == false) {
                    for(int i = n - 1; i >= 1; i--) {   // Loop n times going up
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                if(down == true) {  // Change down flag so snake knows which direction it followed last
                    down = false;
                }
                else {
                    down = true;
                }

            }
        }

        // W4-Handle case w n-1 n-1
        if(d == 'w' && x == (n-1) && y == (n-1)) {
            down = false;
            //.out.println("case w 0 n-1");
            int time = 1;                       // Start time

            // Go Straight left
            for(int i = n-1; i >= 0; i--) {
                grid.get(n-1).set(i, time);
                time++;
            }

            // Then traverse
            for(int col = 0; col <= n - 1; col++) {       // Loop n times from left to right
                // Go down case
                if(down == true) {
                    for(int i = 0; i <= n - 2; i++) {        // Loop n times going down
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                // Go up case
                if(down == false) {
                    for(int i = n - 2; i >= 0; i--) {   // Loop n times going up
                        grid.get(i).set(col, time);
                        time++;
                    }
                }
                if(down == true) {  // Change down flag so snake knows which direction it followed last
                    down = false;
                }
                else {
                    down = true;
                }

            }
        }


        // S1-Handle case s 0 0
        if(d == 's' && x == 0 && y == 0) {
            right = true;
            //.out.println("case s 0 0");
            int time = 1;                       // Start time

            // Go Straight down
            for(int i = 0; i <= n - 1; i++) {
                grid.get(i).set(0, time);
                time++;
            }

            // Then traverse
            for(int row = n - 1; row >= 0; row--) {       // Loop n times from top to bottom
                // Go right case
                if(right == true) {
                    for(int i = 1; i <= n - 1; i++) {        // Loop n times going right
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                // Go left case
                if(right == false) {
                    for(int i = n - 1; i >= 1; i--) {       // Loop n times going left
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                if(right == true) {  // Change down flag so snake knows which direction it followed last
                    right = false;
                }
                else {
                    right = true;
                }

            }
        }

        // S2-Handle case s n-1 0
        if(d == 's' && x == (n-1) && y == 0) {
            right = true;
            //.out.println("case s n-1 0");
            int time = 1;                       // Start time

            // Traverse
            for(int row = n - 1; row >= 0; row--) {       // Loop n times from top to bottom
                // Go right case
                if(right == true) {
                    for(int i = 0; i <= n - 1; i++) {        // Loop n times going right
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                // Go left case
                if(right == false) {
                    for(int i = n - 1; i >= 0; i--) {       // Loop n times going left
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                if(right == true) {  // Change down flag so snake knows which direction it followed last
                    right = false;
                }
                else {
                    right = true;
                }

            }
        }

        // S3-Handle case s 0 n-1
        if(d == 's' && x == 0 && y == n-1) {
            right = false;
            //.out.println("case s3 0 n-1");
            int time = 1;                       // Start time

            // Go Straight down
            for(int i = 0; i <= n - 1; i++) {
                grid.get(i).set(n-1, time);
                time++;
            }

            // Then traverse
            for(int row = n - 1; row >= 0; row--) {       // Loop n times from top to bottom
                // Go right case
                if(right == true) {
                    for(int i = 0; i <= n - 2; i++) {        // Loop n times going right
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                // Go left case
                if(right == false) {
                    for(int i = n - 2; i >= 0; i--) {       // Loop n times going left
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                if(right == true) {  // Change down flag so snake knows which direction it followed last
                    right = false;
                }
                else {
                    right = true;
                }

            }
        }

        // S4-Handle case s n-1 n-1
        if(d == 's' && x == (n-1) && y == (n-1)) {
            right = false;
            //.out.println("case s4 n-1 n-1");
            int time = 1;                       // Start time

            // Traverse
            for(int row = n - 1; row >= 0; row--) {       // Loop n times from top to bottom
                // Go right case
                if(right == true) {
                    for(int i = 0; i <= n - 1; i++) {        // Loop n times going right
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                // Go left case
                if(right == false) {
                    for(int i = n - 1; i >= 0; i--) {       // Loop n times going left
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                if(right == true) {  // Change down flag so snake knows which direction it followed last
                    right = false;
                }
                else {
                    right = true;
                }

            }
        }

        // N1-Handle case s 0 0
        if(d == 'n' && x == 0 && y == 0) {
            right = true;
            //.out.println("case n 0 0");
            int time = 1;                       // Start time

            // Traverse
            for(int row = 0; row <= n-1; row++) {       // Loop n times from top to bottom
                // Go right case
                if(right == true) {
                    for(int i = 0; i <= n - 1; i++) {        // Loop n times going right
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                // Go left case
                if(right == false) {
                    for(int i = n - 1; i >= 0; i--) {       // Loop n times going left
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                if(right == true) {  // Change down flag so snake knows which direction it followed last
                    right = false;
                }
                else {
                    right = true;
                }

            }
        }

        // N2-Handle case s n-1 0
        if(d == 'n' && x == (n-1) && y == 0) {
            right = true;
            //.out.println("case n n-1 0");
            int time = 1;                       // Start time

            // Go Straight up
            for(int i = n-1; i >= 0; i--) {
                grid.get(i).set(0, time);
                time++;
            }

            // Traverse
            for(int row = 0; row <= n-1; row++) {       // Loop n times from top to bottom
                // Go right case
                if(right == true) {
                    for(int i = 1; i <= n - 1; i++) {        // Loop n times going right
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                // Go left case
                if(right == false) {
                    for(int i = n - 1; i >= 1; i--) {       // Loop n times going left
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                if(right == true) {  // Change down flag so snake knows which direction it followed last
                    right = false;
                }
                else {
                    right = true;
                }

            }
        }

        // N3-Handle case n 0 n-1
        if(d == 'n' && x == 0 && y == n-1) {
            right = false;
            //.out.println("case n 0 n-1");
            int time = 1;                       // Start time

            // Traverse
            for(int row = 0; row <= n-1; row++) {       // Loop n times from top to bottom
                // Go right case
                if(right == true) {
                    for(int i = 0; i <= n - 1; i++) {        // Loop n times going right
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                // Go left case
                if(right == false) {
                    for(int i = n - 1; i >= 0; i--) {       // Loop n times going left
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                if(right == true) {  // Change down flag so snake knows which direction it followed last
                    right = false;
                }
                else {
                    right = true;
                }
            }
        }

        // N4-Handle case s n-1 n-1
        if(d == 'n' && x == (n-1) && y == (n-1)) {
            right = false;
            //.out.println("case n n-1 n-1");
            int time = 1;                       // Start time

            // Go Straight up
            for(int i = n-1; i >= 0; i--) {
                grid.get(i).set(n-1, time);
                time++;
            }

            // Traverse
            for(int row = 0; row <= n-1; row++) {       // Loop n times from top to bottom
                // Go right case
                if(right == true) {
                    for(int i = 0; i <= n - 2; i++) {        // Loop n times going right
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                // Go left case
                if(right == false) {
                    for(int i = n - 2; i >= 0; i--) {       // Loop n times going left
                        grid.get(row).set(i, time);
                        time++;
                    }
                }
                if(right == true) {  // Change down flag so snake knows which direction it followed last
                    right = false;
                }
                else {
                    right = true;
                }
            }
        }


        //print the grid
        //.out.println();
        //.out.println();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

