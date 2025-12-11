package searching;

public class LinearSearch {
    public int linearSearch(int[] array, int key) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        LinearSearch linearSearchObj = new LinearSearch();
        System.out.println(linearSearchObj.linearSearch(array, 3));
        System.out.println(linearSearchObj.linearSearch(array, 8));
    }
}
