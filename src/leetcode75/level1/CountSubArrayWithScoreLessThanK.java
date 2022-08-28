package leetcode75.level1;

public class CountSubArrayWithScoreLessThanK {

    public long countSubarrays(int[] nums, long k) {
        int start = 0;
        int sum = 0;
        int count = 0;

        for (int end = 0; end < nums.length; end ++) {

            sum += sum + nums[end];

            if (sum * (end-start + 1) < k) {
                count += end-start + 1;
            }

            while (sum * (end-start+1) > k) {
                sum = sum - nums[start];
                start++;

            }


        }
        return count;
    }
}
