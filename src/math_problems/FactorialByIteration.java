package math_problems;

import java.util.Scanner;
public class FactorialByIteration {
    /**
     * INSTRUCTIONS
     * <p>
     * Write a method to return the Factorial of any given number using Recursion, and also another way, using iteration
     * I have not taught you recursion. Your job is to look it up, learn about it, and use it to find a solution.
     * <p>
     * HINT: Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120
     */


    // *****************// Factorial By Iteration Method // ///*****************


    public static long fctrl(int numbr) {
        long result = 1;
        for (int i = 1; i <= numbr; i++) {
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println(" Please enter the number, which number's Factorial you need, but not more than 25");
        int num = scr.nextInt();
        for (int k = 0; k <= num; k++) {
            System.out.println("Factorial of " + k + " is: " + fctrl(k) + ";");
        }
    }
}