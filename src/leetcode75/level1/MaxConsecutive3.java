package leetcode75.level1;

public class MaxConsecutive3 {

    public int longestOnes(int[] nums, int k) {
        if (nums.length == 0) return 0;
        if (nums.length < k) return nums.length;
        int start = 0;
        int max = 0;
        for (int end = 0; end < nums.length; end++) {

            if(nums[end] == 0) {
                k--;
            }
            if (k >= 0) {
                max = Math.max(max, end - start + 1);
            } else {
                max = Math.max(max, end - start);
            }

            while (k < 0) {
                if (nums[start++] == 0) {
                    k++;
                }
            }
        }
        return max;
    }

    public int longestOnes2(int[] nums, int k) {
        int start = 0;
        int end;
        for (end = 0; end < nums.length; end ++) {
            if (nums[end] == 0) k--;
            if (k < 0) {
                if (nums[start] == 0) {
                    k++;
                }
                start++;
            }
        }
        return end - start;
    }
}
