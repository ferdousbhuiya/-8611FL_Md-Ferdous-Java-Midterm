package math_problems;

public class PrimeNumber {

    /** INSTRUCTIONS
     * Write a method to print a list of all prime numbers from 2 to 1,000,000.
     *  Print out the prime numbers in the given range.
     *
     * BONUS: Figure out how to improve algorithmic efficiency
     */


    public static void main(String[] args) {
primenmbr(1000000);
    }


    static void primenmbr(int x)
    {
        int temp=0;
        for (int i=1; i<=x; i++) {
            if (i % 2 != 0) {
                for (int k = 2; k < i - 1; k++) {
                    if (i % k == 0) {
                        temp = temp + 1;
                    }
                }
                if (temp == 0) {
                    System.out.println(i);
                } else {
                    temp = 0;
                }
            }
        }
        }

    }

// If we use normal iteration, it will take long time, by filtering the even numbers, it reduces time.