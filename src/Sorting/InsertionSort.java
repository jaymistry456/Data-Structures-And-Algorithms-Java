package Sorting;

public class InsertionSort {
    public void insertionSort (int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    public static void main (String[] args) {
        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        InsertionSort insertionSortObj = new InsertionSort();
        insertionSortObj.insertionSort(array);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
