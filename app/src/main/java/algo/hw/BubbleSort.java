package algo.hw;

//Lu Henry-Mitchell

public class BubbleSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j <arr.length - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}