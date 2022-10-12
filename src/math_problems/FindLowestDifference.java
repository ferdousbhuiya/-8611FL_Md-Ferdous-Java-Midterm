package math_problems;

public class FindLowestDifference {

    /**
     * INSTRUCTIONS
     * Write a method to return the lowest number, that is not shared between the 2 arrays below
     * HINT: The lowest number that isn't shared between these arrays is 1
     */
    static void smallestDiff(int[] a, int[] b)
    {
        try {
            int[] uncmn = new int[0];
            int i = 0;
            for (i = 0; i < a.length; i++)
            {
                for (int k = 0; k < b.length; k++)
                    if (a[i] != b[k])
                    {
                        uncmn[i] = a[i];
                        //System.out.println(a[i]);
                    }
                //System.out.println(uncmn[i]);
            }
            System.out.println(uncmn[i]);
        }
        catch (Exception e)
        {

        }
        }




    public static void main(String[] args) {


        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1, -15};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19, -15};


        smallestDiff(array1,array2);

    }



}
