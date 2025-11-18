public class Arrays {
    public static void main(String[] args) {
        int[] array = new int[7];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        for (int j : array) {
            System.out.println(j);
        }
    }
}