import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random randomGenerator = new Random();
        System.out.println("Enter size of your array");//get user input for array size
        int n = sc.nextInt();
        int a[] = new int[n];
        int low =0;
        int high = a.length -1;

        System.out.println("UNSORTED");
        for (int i=0;i< a.length;i++)//create array with random ints
        {
            a[i] = randomGenerator.nextInt((65536)-32768); // personal decision to make only positive integers
            System.out.println(a[i]);
        }

        int temp[] = new int[n];
        System.arraycopy( a, 0, temp, 0, a.length );


//picking the 4 pivots
        long startTime = System.currentTimeMillis();
        quickSortFirstElement(a,low,high);
        long endTime = System.currentTimeMillis();
        System.out.println("sorted");
        for (int i=0;i< a.length;i++)//create array with random ints
        {
            System.out.println(a[i]);
        }
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        System.arraycopy( temp, 0, a, 0, temp.length );
        startTime = System.currentTimeMillis();
        quickSortRandom(a,low,high);
        endTime = System.currentTimeMillis();
        System.out.println("sorted");
        for (int i=0;i< a.length;i++)//create array with random ints
        {
            System.out.println(a[i]);
        }
        System.out.println("That took " + (endTime - startTime) + " milliseconds");


        System.arraycopy( temp, 0, a, 0, temp.length );
        startTime = System.currentTimeMillis();
        quickSortMedianRandom(a,low,high);
        endTime = System.currentTimeMillis();
        System.out.println("sorted");
        for (int i=0;i< a.length;i++)//create array with random ints
        {
            System.out.println(a[i]);
        }
        System.out.println("That took " + (endTime - startTime) + " milliseconds");


        System.arraycopy( temp, 0, a, 0, temp.length );
        startTime = System.currentTimeMillis();
        quickSortMedianOfThree(a,low,high);
        endTime = System.currentTimeMillis();
        System.out.println("sorted");
        for (int i=0;i< a.length;i++)//create array with random ints
        {
            System.out.println(a[i]);
        }
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

    }

    public static void quickSortFirstElement(int[] arr, int low, int high)
    {

        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot as the first element of the array
        int pivot = arr[0];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSortFirstElement(arr, low, j);


    }

    public static void quickSortRandom(int[] arr, int low, int high)
    {

        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot as random element
        Random r = new Random();
        int result = r.nextInt(high-low) + low;
        int pivot = arr[result];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSortRandom(arr, low, j);

        if (high > i)
            quickSortRandom(arr, i, high);

    }

    public static void quickSortMedianRandom(int[] arr, int low, int high)
    {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot median of three random values
        Random r = new Random();
        int randomInts[]= new int[3];
        randomInts[0] = arr[0];
        randomInts[1] = arr[arr.length/2];
        randomInts[2] = arr[high];

        Arrays.sort(randomInts);
        int pivot = randomInts[1];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSortRandom(arr, low, j);

        if (high > i)
            quickSortRandom(arr, i, high);

    }
    public static void quickSortMedianOfThree(int[] arr, int low, int high)
    {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot median of three random values
        Random r = new Random();
        int randomInts[]= new int[3];
        randomInts[0] = arr[r.nextInt(high-low) + low];
        randomInts[1] = arr[r.nextInt(high-low) + low];
        randomInts[2] = arr[r.nextInt(high-low) + low];

        Arrays.sort(randomInts);
        int pivot = randomInts[1];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSortRandom(arr, low, j);

        if (high > i)
            quickSortRandom(arr, i, high);

    }


}

