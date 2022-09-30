package leetcode75.level1.twopointers;

public class ShortestWindowSort {

    public static int sort(int[] arr) {
        int low = 0, high = arr.length-1;

        while (low < arr.length - 1) {
            if (arr[low+1] < arr[low]) {
                break;
            }
            low++;
        }

        if (low == arr.length - 1) {
            return 0;
        }

        while (high > 0) {
            if (arr[high - 1] > arr[high]) {
                break;
            }
            high--;
        }

        int minSubArray = Integer.MAX_VALUE;
        int maxSubArray = Integer.MIN_VALUE;

        for (int i = low; i <= high; i++) {
            if (arr[i] < minSubArray) minSubArray = arr[i];
            if (arr[i] > maxSubArray) maxSubArray = arr[i];
        }

        while (low > 0) {
            if (arr[low-1] <= minSubArray) {
                break;
            }
            low--;
        }

        while (high < arr.length-1) {
            if (arr[high + 1] >= maxSubArray) {
                break;
            }
            high++;
        }

        return high - low + 1;
    }

    public static void main(String[] args) {
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
    }
}
