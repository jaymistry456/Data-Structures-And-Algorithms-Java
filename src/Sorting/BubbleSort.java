package Sorting;

public class BubbleSort {
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        BubbleSort bubbleSortObj = new BubbleSort();
        bubbleSortObj.bubbleSort(array);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
