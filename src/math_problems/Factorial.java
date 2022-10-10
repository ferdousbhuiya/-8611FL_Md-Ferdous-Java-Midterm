package math_problems;

import java.util.Scanner;

public class Factorial {

    /** INSTRUCTIONS
     *
     * Write a method to return the Factorial of any given number using Recursion, and also another way, using iteration
     * I have not taught you recursion. Your job is to look it up, learn about it, and use it to find a solution.
     *
     * HINT: Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120
     */

    public static void main(String[] args) {
        String yn;
        int num;
        do {
            Scanner s = new Scanner(System.in);
            System.out.println(" Please enter the number, which number's Factorial you need, but not more than 25");
            num = s.nextInt();

            System.out.println("Factorial of " +num+" is: " +facto(num)+";");
            System.out.println("Do you want to continue (Press 'y' for 'yes' and 'n' for no )");
            yn = s.next();
        } while (yn.equals("y") || yn.equals("Y"));
    }
    public static int facto(int num)
    {
        if (num ==1)
        {
            return 1;
        }
        else
        {
            return num*facto(num-1);
        }
    }

}
