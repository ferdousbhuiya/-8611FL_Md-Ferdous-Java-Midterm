package math_problems;

public class FindMissingNumber {

    /** INSTRUCTIONS
     * Write a method to find the missing number from the array.
     */

    public static void main(String[] args) {
        int[] array = new int[] {10, 2, 1, 4, 5, 3, 7, 8, 6};
        System.out.println("The missing number is: "+ missingnmbr(array));
    }


    static int  missingnmbr(int [] a)

    {
        int xor1 = a[0];
        for (int i=1; i<a.length; i++)
        {
            xor1 = xor1^a[i];
        }
        int xor2 = 1;
        for (int k=2; k<=(a.length+1); k++)
        {
            xor2= xor2^k;
        }
        return xor1^xor2;
    }

}
