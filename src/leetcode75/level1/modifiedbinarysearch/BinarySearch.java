package leetcode75.level1.modifiedbinarysearch;

public class BinarySearch {

    public static int search(int[] arr, int key) {
        int start = 0, end = arr.length - 1;

        boolean isAsc = arr[end] >= arr[start];

        while (start <= end) {

            int mid = start + (end - start)/2;

            if (key == arr[mid]) return mid;

            if (isAsc) {
                if (key < arr[mid]) {
                    end= mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (key > arr[mid]) {
                    end =  mid -1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
        System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
    }
}
