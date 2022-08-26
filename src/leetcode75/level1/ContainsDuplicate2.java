package leetcode75.level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums.length == 0)
            return false;

        int start = 0;

        Set<Integer> set = new HashSet<>();

        for (int end = 0; end < nums.length; end++) {
            if (end - start > k) {
                set.remove(nums[start]);
                start++;
            }

            if (!set.add(nums[end])) {
                return true;
            }
        }

        return false;
    }
}
