package leetcode75.level1.twopointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {

        int smallestDifference = Integer.MAX_VALUE;

        Arrays.sort(arr);
        for (int i =0; i < arr.length - 2; i++) {
            int left = i+1;
            int right = arr.length - 1;

            while (left < right) {
                int diffSum = targetSum - arr[i] - arr[left] - arr[right];

                if (diffSum == 0) {
                    return targetSum;
                }

                if (Math.abs(diffSum) < Math.abs(smallestDifference) || ( Math.abs(diffSum) == smallestDifference && diffSum > smallestDifference )) {
                    smallestDifference = diffSum;
                }

                if (diffSum > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return smallestDifference;
    }
}
