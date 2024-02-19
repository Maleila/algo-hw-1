package algo.hw;

//Lu Henry-Mitchell

import java.util.*;

public class Sorts {
    public static void printArray(int[] array){
        for(int i = 0; i < array.length-1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length -1]);
    }

    public static void main(String[] args) {
        int[] test = {4, 3, 6, 1, 3, 5, 4, 5, 5, 5};

        BubbleSort b = new BubbleSort();
        //int[] bubble = b.sort(test);

        MergeSort m = new MergeSort();
        int[] bubble = m.sort(test);

        System.out.println("SORTED: ");
        for(int i = 0; i < bubble.length-1; i++) {
            System.out.print(bubble[i] + ", ");
        }
        System.out.println(bubble[bubble.length -1]);
        
    }

    public static int[] randArray(int length) {
        int[] a = new int[length];

        Random rand = new Random();

        for(int i = 0; i < length; i++) {
            a[i] = rand.nextInt(1000); 
        }

        return a;
    }

    public static double timeSort(int[] arr, SortAlgorithm s) {
        double start = System.nanoTime();
        s.sort(arr);
        double stop = System.nanoTime();
        return start-stop;
    }

    public static double[] repeatedSort(int n, int k, SortAlgorithm s) {
        double[] sortTimes = new double[k];

        for(int i = 0; i < k; i++) {
            sortTimes[i] = timeSort(randArray(n), s);
        }

        return sortTimes;
    }
}