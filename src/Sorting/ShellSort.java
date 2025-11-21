package Sorting;

public class ShellSort {
    public void shellSort (int[] array) {
        for (int gap = array.length/2; gap > 0; gap/=2) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
        }
    }

    public static void main (String[] args) {
        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        ShellSort shellSortObj = new ShellSort();
        shellSortObj.shellSort(array);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
