package sorting;

import java.util.List;
import java.util.Random;

import databases.SharedStepsDatabase;

    /** INSTRUCTIONS
     * Demonstrate all the different kind of sorting algorithms from the Sorting class. There is an example provided
     *  below to get you started.
     *
     *  You must store all the sorted arrays into their own database table, and retrieve the values and print them
     *  Display the execution time for each sorting - Example below.
     *
     *  You may use any database, such as MongoDB, Oracle MySql, PostgreSQL, etc, to store data and retrieve data.
     *
     *  BONUS: Come to a conclusion about which sorting algorithm is the most efficient, given data sets with a size of:
     *         10
     *         100
     *         1000
     *         10000
     *         100000
     */

public class SortEfficiency {

    public static void main(String[] args) throws Exception {
        // Declare and initialize an array of a desired length with random numbers (Try this with 100, 1000, 10000, 100000)
        int[] numberArray = new int[1000];
        insertRandomNumbersIntoArray(numberArray);

        SortingAlgorithms sort = new SortingAlgorithms();
        SharedStepsDatabase sharedStepsDatabase = new SharedStepsDatabase();

        // region Selection Sort
        numberArray = sort.selectionSort(numberArray);
        long selectionSortExecutionTime = sort.executionTime;

        System.out.println("\n\n============================-- SELECTION SORT --============================\nArray Length: " + numberArray.length + "\nExecution Time: "
                + selectionSortExecutionTime + " milliseconds");
        System.out.println("Total Execution Time of " + numberArray.length + " numbers in Selection Sort took: "
                + selectionSortExecutionTime + " milliseconds\n");

        // Insert sorted array into a database table, with the desired table name and column name
        sharedStepsDatabase.insertIntegerArray("selection_sort", "sorted_numbers", numberArray);

        // Retrieve all elements from the newly created table
        String query = "SELECT * FROM SELECTION_SORT";
        List<String> sorted_numbers = sharedStepsDatabase.executeQueryReadAllSingleColumn(query, "sorted_numbers");
        printValue(sorted_numbers);

        // endregion

        // You must randomize the number array after each sorting algorithm to prepare it for the next sorting algorithm
        randomize(numberArray);

        // region Insertion Sort
        numberArray = sort.insertionSort(numberArray);
        long insertionSortExecutionTime = sort.executionTime;
        System.out.println("\n\n=============================- INSERTION SORT -=============================\nArray Length: " + numberArray.length + "\nExecution Time: "
                + insertionSortExecutionTime + " milliseconds");
        System.out.println("Total Execution Time of " + numberArray.length + " numbers in Insertion Sort took: "
                + insertionSortExecutionTime + " milliseconds\n");
        sharedStepsDatabase.insertIntegerArray("insertion_sort", "insertionSorted_numbers", numberArray);
        String query1 = "SELECT * FROM insertion_sort";
        List<String> insertionSorted_numbers = sharedStepsDatabase.executeQueryReadAllSingleColumn(query1, "insertionSorted_numbers");
        printValue(insertionSorted_numbers);

        // endregion

        randomize(numberArray);

        // region Bubble Sort
        numberArray = sort.bubbleSort(numberArray);
        long bubbleSortExecutionTime = sort.executionTime;
        System.out.println("\n\n=============================- BUBBLE SORT -=============================\nArray Length: " + numberArray.length + "\nExecution Time: "
                + bubbleSortExecutionTime + " milliseconds");
        System.out.println("Total Execution Time of " + numberArray.length + " numbers in Bubble Sort took: "
                + bubbleSortExecutionTime + " milliseconds\n");
        sharedStepsDatabase.insertIntegerArray("bubble_sort", "bubbleSorted_numbers", numberArray);
        String query2 = "SELECT * FROM bubble_sort";
        List<String> bubbleSorted_numbers = sharedStepsDatabase.executeQueryReadAllSingleColumn(query2, "bubbleSorted_numbers");
        printValue(bubbleSorted_numbers);
        // endregion

        randomize(numberArray);

        // region Merge Sort
        numberArray = sort.mergeSort(numberArray, 0, numberArray.length - 1);
        long mergeSortExecutionTime = sort.executionTime;

        System.out.println("\n\n=============================- MERGE SORT -=============================\nArray Length: " + numberArray.length + "\nExecution Time: "
                + mergeSortExecutionTime + " milliseconds");
        System.out.println("Total Execution Time of " + numberArray.length + " numbers in Merge Sort took: "
                + mergeSortExecutionTime + " milliseconds\n");
        sharedStepsDatabase.insertIntegerArray("merge_sort", "mergeSorted_numbers", numberArray);
        String query3 = "SELECT * FROM merge_sort";
        List<String> mergeSorted_numbers = sharedStepsDatabase.executeQueryReadAllSingleColumn(query3, "mergeSorted_numbers");
        printValue(mergeSorted_numbers);
        // endregion

        randomize(numberArray);

        // region Quick Sort
        numberArray = sort.quickSort(numberArray, 0, numberArray.length - 1);
        long quickSortExecutionTime = sort.executionTime;

        System.out.println("\n\n=============================- QUICK SORT -=============================\nArray Length: " + numberArray.length + "\nExecution Time: "
                + quickSortExecutionTime + " milliseconds");
        System.out.println("Total Execution Time of " + numberArray.length + " numbers in Quick Sort took: "
                + quickSortExecutionTime + " milliseconds\n");
        sharedStepsDatabase.insertIntegerArray("quick_sort", "quickSorted_numbers", numberArray);
        String query4 = "SELECT * FROM quick_sort";
        List<String> quickSorted_numbers = sharedStepsDatabase.executeQueryReadAllSingleColumn(query4, "quickSorted_numbers");
        printValue(quickSorted_numbers);
        // endregion

        randomize(numberArray);

        // region Heap Sort
        numberArray = sort.heapSort(numberArray);
        long heapSortExecutionTime = sort.executionTime;
        System.out.println("\n\n=============================- HEAP SORT -=============================\nArray Length: " + numberArray.length + "\nExecution Time: "
                + heapSortExecutionTime + " milliseconds");
        System.out.println("Total Execution Time of " + numberArray.length + " numbers in Heap Sort took: "
                + heapSortExecutionTime + " milliseconds\n");
        sharedStepsDatabase.insertIntegerArray("heap_sort", "heapSorted_numbers", numberArray);
        String query5 = "SELECT * FROM heap_sort";
        List<String> heapSorted_numbers = sharedStepsDatabase.executeQueryReadAllSingleColumn(query5, "heapSorted_numbers");
        printValue(heapSorted_numbers);
        // endregion

        randomize(numberArray);

        // region Bucket Sort
        numberArray = sort.bucketSort(numberArray, SortingAlgorithms.maximumValue(numberArray));
        long bucketSortExecutionTime = sort.executionTime;
        System.out.println("\n\n=============================- BUCKET SORT -=============================\nArray Length: " + numberArray.length + "\nExecution Time: "
                + bucketSortExecutionTime + " milliseconds");
        System.out.println("Total Execution Time of " + numberArray.length + " numbers in Bucket Sort took: "
                + bucketSortExecutionTime + " milliseconds\n");
        sharedStepsDatabase.insertIntegerArray("bucket_sort", "bucketSorted_numbers", numberArray);
        String query6 = "SELECT * FROM bucket_sort";
        List<String> bucketSorted_numbers = sharedStepsDatabase.executeQueryReadAllSingleColumn(query6, "bucketSorted_numbers");
        printValue(bucketSorted_numbers);
        // endregion

        randomize(numberArray);

        // region Shell Sort
        numberArray = sort.shellSort(numberArray, numberArray.length);
        long shellSortExecutionTime = sort.executionTime;
        System.out.println("\n\n=============================- SHELL SORT -=============================\nArray Length: " + numberArray.length + "\nExecution Time: "
                + shellSortExecutionTime + " milliseconds");
        System.out.println("Total Execution Time of " + numberArray.length + " numbers in Shell Sort took: "
                + shellSortExecutionTime + " milliseconds\n");
        sharedStepsDatabase.insertIntegerArray("shell_sort", "shellSorted_numbers", numberArray);
        String query7 = "SELECT * FROM shell_sort";
        List<String> shellSorted_numbers = sharedStepsDatabase.executeQueryReadAllSingleColumn(query7, "shellSorted_numbers");
        printValue(shellSorted_numbers);
        // endregion


        System.out.println("======----- Comparison of the sorting times for the same numbers of element -----==========");
        System.out.println("Total number of Element : "+numberArray.length);
        System.out.println("Execution time for Selection Sort: "+selectionSortExecutionTime+" milliseconds.");
        System.out.println("Execution time for Insertion Sort: "+insertionSortExecutionTime+" milliseconds.");
        System.out.println("Execution time for Bubble Sort: "+bubbleSortExecutionTime+" milliseconds.");
        System.out.println("Execution time for Merge Sort: "+mergeSortExecutionTime+" milliseconds.");
        System.out.println("Execution time for Quick Sort: "+quickSortExecutionTime+" milliseconds.");
        System.out.println("Execution time for Heap Sort: "+heapSortExecutionTime+" milliseconds.");
        System.out.println("Execution time for Bucket Sort: "+bucketSortExecutionTime+" milliseconds.");
        System.out.println("Execution time for Shell Sort: "+shellSortExecutionTime+" milliseconds.");

    }

    // region Helper Methods
    /**
     * Inserts random integers into an int[] array. All numbers have an upper bound of 1,000,000
     *
     * @param array Array to insert numbers into
     */
    private static void insertRandomNumbersIntoArray(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000000);
        }
    }

    /**
     * Randomizes the numbers in an int[] array
     *
     * @param array The array to be randomized
     */
    private static void randomize(int[] array) {
        Random r = new Random();
        int n = array.length;

        /*
         Start from the last element and swap one by one. We don't
         need to run for the first element that's why i > 0
         */
        for (int i = n - 1; i > 0; i--) {
            int j = r.nextInt(i);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * Prints all values in a List<String>
     *
     * @param list List containing the values to be printed
     */
    private static void printValue(List<String> list) {
        for (String st : list) {
            System.out.println(st);
        }
    }

    // endregion
}
