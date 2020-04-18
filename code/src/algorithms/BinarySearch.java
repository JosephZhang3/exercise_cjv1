package algorithms;

/**
 * 二分查找，手写精简代码
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int key = 3;
        System.out.println(find(a, key));
    }

    private static int find(int[] a, int key) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > a[mid]) {
                lo = mid + 1;
            } else if (key < a[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
