package leetcode75.level1.dynamicprogramming;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int l = 0, r = 0;
        int res = Integer.MIN_VALUE;

        for (int i = 0 ; i < nums.length; i++) {
            l = (l == 0 ? 1 : l) * nums[i];
            r = (r == 0 ? 1 : r) * nums[nums.length - 1 -i];

            res =  Math.max(res, Math.max(l,r));
        }

        return res;
    }

}
