package sorting;

public class InsertionSort {
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        InsertionSort insertionSortObj = new InsertionSort();
        insertionSortObj.insertionSort(array);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
