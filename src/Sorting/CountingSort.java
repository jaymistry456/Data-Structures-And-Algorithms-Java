package Sorting;

public class CountingSort {
    public void countingSort(int[] array, int min, int max) {
        int[] countArray =  new int[max - min + 1];
        for(int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        int j = 0;
        for(int i = min; i <= max; i++) {
            while(countArray[i - min] > 0) {
                array[j] = i;
                j++;
                countArray[i - min]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        CountingSort countingSortObj = new CountingSort();
        countingSortObj.countingSort(array, 1, 7);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
