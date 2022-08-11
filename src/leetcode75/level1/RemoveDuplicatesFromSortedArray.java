package leetcode75.level1;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                count++;
                set.add(nums[i]);
                nums[count - 1] = nums[i];
            }
        }
        return count;
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i-1])
                nums[i++] = n;
        return i;
    }
}
