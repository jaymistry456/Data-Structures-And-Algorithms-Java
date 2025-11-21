package Sorting;

import java.util.Arrays;

public class BuiltInSort {
    public static void main(String[] args) {
        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        Arrays.sort(array);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
