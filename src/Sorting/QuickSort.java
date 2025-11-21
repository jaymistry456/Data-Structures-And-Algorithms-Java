package Sorting;

public class QuickSort {
    public int partition(int[] array, int l, int r) {
        int pivot = array[l];
        int start = l + 1;
        int end = r;
        while(start <= end) {
            while(start <= end && array[start] <= pivot) {
                start++;
            }
            while(start <= end && array[end] >= pivot) {
                end--;
            }
            if(start > end) {
                break;
            }
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        array[l] = array[end];
        array[end] = pivot;
        return end;
    }

    public void quickSort(int[] array, int l ,int r) {
        if(l < r) {
            int partitionIdx = partition(array, l, r);
            quickSort(array, l, partitionIdx - 1);
            quickSort(array, partitionIdx + 1, r);
        }
    }

    public static void main (String[] args) {
        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        QuickSort quickSortObj = new QuickSort();
        quickSortObj.quickSort(array, 0, array.length - 1);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
