package sorting;

public class SortingAlgorithms {


    /**
     * INSTRUCTIONS
     * You must implement all of the sorting algorithms below. Feel free to add any helper methods that you may need,
     * but make sure they are private, as to not be accessed outside of this class.
     * <p>
     * You must also store the sorted arrays into their own individual database tables (Selection Sort should be stored
     * in table `selection_sort`, Insertion Sort should be stored in table `insertion_sort`)
     */

    long executionTime = 0;

    public static void printSortedArray(int[] array) {
        for (int k = 0; k < array.length; k++) {
            System.out.println(array[k]);
        }
    }
    public int[] selectionSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        for (int m = 0; m < array.length - 1; m++) {
            int min = m;
            for (int j = m + 1; j < array.length; j++) {
                if (array[j] < array[min])
                    min = j;
            }
            int temp = array[min];
            array[min] = array[m];
            array[m] = temp;
        }
        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;
        return array;
    }

    public int[] insertionSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        // IMPLEMENT HERE
        int n = array.length;
        for (int ii = 1; ii < n; ++ii) {
            int key = array[ii];
            int ji = ii - 1;

            while (ji >= 0 && array[ji] > key) {
                array[ji + 1] = array[ji];
                ji = ji - 1;
            }
            array[ji + 1] = key;
        }
        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;
        return array;
    }

    public int[] bubbleSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        // IMPLEMENT HERE
        int n = array.length;
        for (int ib = 0; ib < n - 1; ib++)
            for (int jb = 0; jb < n - ib - 1; jb++)
                if (array[jb] > array[jb + 1]) {
                    int temp = array[jb];
                    array[jb] = array[jb + 1];
                    array[jb + 1] = temp;
                }
        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;
        return array;
    }

    public int[] mergeSort(int[] array, int start, int arrayLength) {
        final long startTime = System.currentTimeMillis();
        // IMPLEMENT HERE
        if (start < arrayLength) {
            int ms = start + (arrayLength - start) / 2;
            mergeSort(array, start, ms);
            mergeSort(array, ms + 1, arrayLength);
            merge(array, start, ms, arrayLength);
        }
        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;
        return array;
    }
    private void merge(int arr[], int lm, int mm, int rm) {
        int nm1 = mm - lm + 1;
        int nm2 = rm - mm;
        int Lm[] = new int[nm1];
        int Rm[] = new int[nm2];
        for (int i = 0; i < nm1; ++i)
            Lm[i] = arr[lm + i];
        for (int jm = 0; jm < nm2; ++jm)
            Rm[jm] = arr[mm + 1 + jm];
        int im = 0, jm = 0;
        int k = lm;
        while (im < nm1 && jm < nm2) {
            if (Lm[im] <= Rm[jm]) {
                arr[k] = Lm[im];
                im++;
            } else {
                arr[k] = Rm[jm];
                jm++;
            }
            k++;
        }
        while (im < nm1) {
            arr[k] = Lm[im];
            im++;
            k++;
        }
        while (jm < nm2) {
            arr[k] = Rm[jm];
            jm++;
            k++;
        }
    }
    public int[] quickSort(int[] array, int low, int high) {
        final long startTime = System.currentTimeMillis();
        // IMPLEMENT HERE

        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;
        return array;
    }
   private int partition(int intArray[], int low, int high) {
        int pi = intArray[high];
        int iq = (low - 1);
        for (int jq = low; jq < high; jq++) {
            if (intArray[jq] <= pi) {
                iq++;
                int temp = intArray[iq];
                intArray[iq] = intArray[jq];
                intArray[jq] = temp;
            }
        }
        int temp = intArray[iq + 1];
        intArray[iq + 1] = intArray[high];
        intArray[high] = temp;
        return iq + 1;
    }
    public int[] heapSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        // IMPLEMENT HERE
        int N = array.length;
        for (int ih = N / 2 - 1; ih >= 0; ih--)
            heapify(array, N, ih);
        for (int ih = N - 1; ih > 0; ih--) {
            int temp = array[0];
            array[0] = array[ih];
            array[ih] = temp;
            heapify(array, ih, 0);
        }
        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;
        return array;
    }
    private void heapify(int arr[], int N, int i) {
        int largest = i;
        int lh = 2 * i + 1;
        int rh = 2 * i + 2;
        if (lh < N && arr[lh] > arr[largest])
            largest = lh;
        if (rh < N && arr[rh] > arr[largest])
            largest = rh;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, N, largest);
        }
    }
    public int[] bucketSort(int[] array, int maximum_value) {
        final long startTime = System.currentTimeMillis();
        int[] newbucket = new int[maximum_value + 1];
        int[] sorted_array = new int[array.length];
        for (int b = 0; b < array.length; b++)
            newbucket[array[b]]++;
        int position = 0;
        for (int bb = 0; bb < newbucket.length; bb++)
            for (int cb = 0; cb < newbucket[bb]; cb++)
                sorted_array[position++] = bb;
        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;
        return sorted_array;
    }
    public static int maximumValue(int[] array) {
        int maximum_value = 0;
        for (int db = 0; db < array.length; db++)
            if (array[db] > maximum_value)
                maximum_value = array[db];
        return maximum_value;
    }
    public int[] shellSort(int[] array, int n) {
        final long startTime = System.currentTimeMillis();
        //implement here
        for (int interval = n / 2; interval > 0; interval /= 2) {
            for (int is = interval; is < n; is += 1) {
                int temp = array[is];
                int js;
                for (js = is; js >= interval && array[js - interval] > temp; js -= interval) {
                    array[js] = array[js - interval];
                }
                array[js] = temp;
            }
        }
        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;
        return array;
    }
}
