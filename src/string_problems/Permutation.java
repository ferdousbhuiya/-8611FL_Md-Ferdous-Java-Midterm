package string_problems;

import java.util.Scanner;

public class Permutation {

    /**
     * INSTRUCTIONS
     * Create a Java program to compute all permutations of any given string
     * <p>
     * e.g. -  "ABC" = "ABC" "ACB" "BAC" "BCA" "CAB" "CBA"
     */
    static void fun(char[] a, int k, int n) {
        if (k == n) {
            String s = String.valueOf(a);
            System.out.println(s);
        } else {
            for (int i = k; i < n; i++) {
                char t = a[i];
                a[i] = a[k];
                a[k] = t;
                fun(a, k + 1, n);
                char s = a[i];
                a[i] = a[k];
                a[k] = s;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Please enter a word for the Permutation");
        String s = stdin.nextLine();
        char[] arr = s.toCharArray();
        fun(arr, 0, arr.length);
    }
    // Implement Here

}
