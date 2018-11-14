package src;

/**
 * 冒泡排序，手写精简代码
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 9, 1, 24};
        sort(arr);
//        for (int e : arr) {
//            System.out.println(e);
//        }
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
