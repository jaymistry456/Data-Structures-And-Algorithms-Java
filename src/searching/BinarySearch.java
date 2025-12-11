package searching;

public class BinarySearch {
    public int iterativeBinarySearch(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(array[mid] == key) {
                return mid;
            }
            else if(array[mid] < key) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int recursiveBinarySearch(int[] array, int start, int end, int key) {
        if(start <= end) {
            int mid = start + (end - start) / 2;
            if(array[mid] == key) {
                return mid;
            }
            else if(array[mid] < key) {
                return recursiveBinarySearch(array, mid + 1, end, key);
            }
            else {
                return recursiveBinarySearch(array, start, mid - 1, key);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        BinarySearch binarySeachObj = new BinarySearch();
        System.out.println(binarySeachObj.iterativeBinarySearch(array, 3));
        System.out.println(binarySeachObj.iterativeBinarySearch(array, 8));
        System.out.println(binarySeachObj.recursiveBinarySearch(array, 0, array.length - 1, 3));
        System.out.println(binarySeachObj.recursiveBinarySearch(array, 0, array.length - 1, 8));
    }
}
