package leetcode75.level1;

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - sumLeft - nums[i] == 0) {
                return i;
            } else {
                sumLeft = sumLeft + nums[i];
                sum = sum - nums[i];
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int[] nums = {1,-1,2};
            System.out.println(pivotIndex(nums));
    }
}
