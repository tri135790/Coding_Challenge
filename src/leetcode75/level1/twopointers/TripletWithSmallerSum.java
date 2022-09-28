package leetcode75.level1.twopointers;

public class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        int count = 0;

        for (int i =0; i < arr.length - 2; i ++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum < target) {
                    count++;
                    left++;
                } else {
                    right--;
                }

                while(left < right && arr[left] == arr[left-1]) {
                    left++;
                }
            }
        }

        return count;
    }
}
