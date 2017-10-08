import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            Triplet triplet = new Triplet(x, y, z);
            System.out.println(triplet.winner());
        }
    }
}

class Triplet {
    int a;
    int b;
    int c;

    public Triplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String winner() {
        int ano = Math.abs(c - a);
        int bno = Math.abs(c - b);
        if(ano == bno) { return "Mouse C"; }
        return bno < ano ? "Cat B" : "Cat A";
    }
}