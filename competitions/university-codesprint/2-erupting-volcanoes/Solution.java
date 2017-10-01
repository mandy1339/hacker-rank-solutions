import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> volList= new ArrayList<ArrayList<Integer>>();     // List of Volcanoes

        //   Input taking
        // / // / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();               // Scan n (grid size)
        int m = in.nextInt();               // Scan m (number of volcanoes)
        for(int a0 = 0; a0 < m; a0++){      // m times
            int x = in.nextInt();               // read x
            int y = in.nextInt();               // read y
            int w = in.nextInt();               // read w
            // Write Your Code Here
            ArrayList<Integer>vol = new ArrayList<Integer>();                   // SingleVolcanoe
            vol.add(x); vol.add(y); vol.add(w);                                 // Update values of vol
            volList.add(vol);                                                   // Add to volList
        }
        in.close();

        // 1- Create grid n x n initialized to 0
        ArrayList<ArrayList<Integer>>grid = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++) {
            grid.add(new ArrayList<Integer>(Collections.nCopies(n, 0)));
        }

        // 1-For every single vol in volList
        for(ArrayList<Integer> vol: volList) {
            int tempX = vol.get(0);
            int tempY = vol.get(1);
            int tempW = vol.get(2);

            // 2-Set center of vol in the coordinates x, y with value w
            int prevCenterVal = grid.get(tempX).get(tempY);
            grid.get(tempX).set(tempY, tempW + prevCenterVal);  // set x,y to w

            for(int t = 1; t < tempW; t++) {        // Run t times (from w-1 to 1) e.g. 3, 2, 1 if w is 4
                // 3-Set the border with corresponding value

                // down
                for(int di = tempX - t + 1; di <= tempX + t; di++) {
                    if(di >= 0 && ((tempY + t) >= 0) && (di <= (n - 1)) && ((tempY + t) <= (n - 1))) {
                        int prePlusNewVal = grid.get(di).get(tempY + t) + tempW - t;
                        grid.get(di).set(tempY + t, prePlusNewVal);
                    }
                }

                // left
                for(int li = tempY + t-1; li >= tempY - t; li--) {
                    if(li >= 0 && (tempX + t) >= 0 && li <= (n - 1) && (tempX + t) <= (n - 1)) {
                        int prePlusNewVal = grid.get(tempX + t).get(li) + tempW - t;
                        grid.get(tempX + t).set(li, prePlusNewVal);
                    }
                }

                // up
                for(int ui = tempX+t-1; ui >= tempX - t; ui--) {
                    if(ui >= 0 && (tempY - t) >= 0 && ui <= (n - 1) && (tempY - t) <= (n - 1)) {
                        int prePlusNewVal= grid.get(ui).get(tempY - t) + tempW - t;
                        grid.get(ui).set(tempY - t, prePlusNewVal);
                    }
                }

                // right
                for(int ri = tempY - t+1; ri <= tempY + t; ri++) {
                    if(ri >= 0 && (tempX - t) >= 0 && ri <= (n - 1) && (tempX - t) <= (n - 1)) {
                        int prePlusNewVal = grid.get(tempX - t).get(ri) + tempW - t;
                        grid.get(tempX - t).set(ri, prePlusNewVal);
                    }
                }
            }
        }

        // 4-Scan the grid find max
        int max = 0;
        for(ArrayList<Integer> row: grid) {
            for(Integer value: row) {
                if(value > max) {
                    max = value;
                }
            }
        }

         //print the grid
//        System.out.println();
//        System.out.println();
//        for(int i = 0; i < n; i++) {
//            System.out.println(grid.get(i).toString());
//        }
//
//        System.out.println();
//        System.out.println();
        System.out.println(max);
    }
}
