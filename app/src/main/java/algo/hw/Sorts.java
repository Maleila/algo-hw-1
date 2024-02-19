package algo.hw;

//Lu Henry-Mitchell

import java.util.*;

public class Sorts {

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();

        MergeSort m = new MergeSort();

        String[][] mergeTotal = new String[60][3];
        String[][] bubbleTotal = new String[60][3];

        double[] sortTimesBubble50 = repeatedSort(50, 10, b);
        bubbleTotal = updateAllTimes(bubbleTotal, sortTimesBubble50, 0, 50);
        double[] sortTimesBubble100 = repeatedSort(100, 10, b);
        bubbleTotal = updateAllTimes(bubbleTotal, sortTimesBubble100, 10, 100);
        double[] sortTimesBubble500 = repeatedSort(500, 10, b);
        bubbleTotal = updateAllTimes(bubbleTotal, sortTimesBubble500, 20, 500);
        double[] sortTimesBubble1000 = repeatedSort(1000, 10, b);
        bubbleTotal = updateAllTimes(bubbleTotal, sortTimesBubble1000, 30, 1000);
        double[] sortTimesBubble5000 = repeatedSort(5000, 10, b);
        bubbleTotal = updateAllTimes(bubbleTotal, sortTimesBubble5000, 40, 5000);
        double[] sortTimesBubble10000 = repeatedSort(10000, 10, b);
        bubbleTotal = updateAllTimes(bubbleTotal, sortTimesBubble10000, 50, 10000);

        double[] sortTimesMerge50 = repeatedSort(50, 10, m);
        mergeTotal = updateAllTimes(mergeTotal, sortTimesMerge50, 0, 50);
        double[] sortTimesMerge100 = repeatedSort(100, 10, m);
        mergeTotal = updateAllTimes(mergeTotal, sortTimesMerge100, 10, 100);
        double[] sortTimesMerge500 = repeatedSort(500, 10, m);
        mergeTotal = updateAllTimes(mergeTotal, sortTimesMerge500, 20, 500);
        double[] sortTimesMerge1000 = repeatedSort(1000, 10, m);
        mergeTotal = updateAllTimes(mergeTotal, sortTimesMerge1000, 30, 1000);
        double[] sortTimesMerge5000 = repeatedSort(5000, 10, m);
        mergeTotal = updateAllTimes(mergeTotal, sortTimesMerge5000, 40, 5000);
        double[] sortTimesMerge10000 = repeatedSort(10000, 10, m);
        mergeTotal = updateAllTimes(mergeTotal, sortTimesMerge10000, 50, 10000);

        CSVhelper.processData(bubbleTotal, "Henry-Mitchell_bubblesort_times.csv");
        CSVhelper.processData(mergeTotal, "Henry-Mitchell_mergeesort_times.csv");
    }

    public static String[][] updateAllTimes(String[][] allTimes, double[] vals, int index, int n) {
        for(int i = 0; i < 10; i++) {
            allTimes[index+i][0] = Double.toString(vals[i]);
            allTimes[index+i][1] = Double.toString(i+1);
            allTimes[index+i][2] = Double.toString(n);
        }
        return allTimes;
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
        return stop - start;
    }

    public static double[] repeatedSort(int n, int k, SortAlgorithm s) {
        double[] sortTimes = new double[k];

        for(int i = 0; i < k; i++) {
            sortTimes[i] = timeSort(randArray(n), s);
        }

        return sortTimes;
    }
}