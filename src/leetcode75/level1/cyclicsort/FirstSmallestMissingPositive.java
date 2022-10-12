package leetcode75.level1.cyclicsort;

public class FirstSmallestMissingPositive {

    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] >= 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++){
            if(j + 1 != nums[j]) {
                return j + 1;
            }
        }
        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
