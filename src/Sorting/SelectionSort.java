package Sorting;

public class SelectionSort {
    public void selectionSort (int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int largestIdx = i;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[largestIdx]) {
                    largestIdx = j;
                }
            }
            int temp = array[i];
            array[i] = array[largestIdx];
            array[largestIdx] = temp;
        }
    }
    public static void main (String[] args) {
        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        SelectionSort selectionSortObj = new SelectionSort();
        selectionSortObj.selectionSort(array);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
