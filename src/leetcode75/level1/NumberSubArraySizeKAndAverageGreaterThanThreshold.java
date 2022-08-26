package leetcode75.level1;

public class NumberSubArraySizeKAndAverageGreaterThanThreshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;


        for (int j = 0; j < arr.length;j++) {

            if (j < k) {
                sum += arr[j];
            } else {
                sum = sum + arr[j] - arr[j-k];
            }

            if (sum/k >= threshold) count++;
        }

        return count;
    }
}
