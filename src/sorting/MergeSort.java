package sorting;

public class MergeSort {
    public void mergeArrays(int[] array, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[l + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = array[mid + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }
            else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(array, l, mid);
            mergeSort(array, mid + 1, r);
            mergeArrays(array, l, mid, r);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        MergeSort mergeSortObj = new MergeSort();
        mergeSortObj.mergeSort(array, 0, array.length - 1);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
