package math_problems;

public class Fibonacci {

    /**
     * INSTRUCTIONS
     * <p>
     * Write a method that will print or return at least 40 Fibonacci number
     * e.g. - 0,1,1,2,3,5,8,13
     **/

    public static void main(String[] args) {
        int n1 = 0, n2 = 1, sum = 1, n = 0, i;
        System.out.print(n1 + " " + n2);
        for (i = 2; i <= 40; i++) {
            sum = n1 + n2;
            System.out.print(" " + sum);
            n1 = n2;
            n2 = sum;
        }
    }
}