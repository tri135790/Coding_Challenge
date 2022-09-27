package leetcode75.level1.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0 ; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i-1]) {
                continue;
            }
            if (arr[i] <= 0) {
                searchPair(arr, -arr[i], i + 1, triplets);
            }
        }

        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left,
                                   List<List<Integer>> triplets ) {
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == targetSum) {
                triplets.add(Arrays.asList(arr[left], arr[right], -targetSum));
                left++;
                right--;
                while(left < right && arr[left] == arr[left - 1]) left++;
                while(left < right && arr[right] == arr[right + 1]) right--;
            } else if (arr[left] + arr[right] > targetSum) {
                right--;
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -3, 0, 1, 2, -1, 1, -2 };
        List<List<Integer>> triplets = searchTriplets(arr);
    }
}
