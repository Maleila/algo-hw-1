package algo.hw;
import java.util.Arrays;

//Lu Henry-Mitchell

public class MergeSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] arr) {
        if(arr.length <= 1) {
            return arr;
        } else {
            int midpoint = arr.length/2;
            int[] left = sort(Arrays.copyOfRange(arr, 0, midpoint));
            int[] right = sort(Arrays.copyOfRange(arr, midpoint, arr.length));
            return merge(left, right, arr.length);
        }
    }

    private int[] merge(int[] left, int[] right, int n) {
        int[] temp = new int[n];
        int i = 0;
        int j = 0;

        int k = 0;
        while (i < left.length || j < right.length) {
            if(i >= left.length || left.length == 0) {
                temp[k] = right[j];
                j++;
            }
            else if(j >= right.length || right.length == 0 || left[i] < right[j]) {
                temp[k] = left[i];
                i++;
            } else {
                temp[k] = right[j];
                j++;
            }
            k++;
        }
        return temp;
    }
}