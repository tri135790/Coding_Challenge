package leetcode75.level1;

import java.util.HashSet;
import java.util.Set;

public class NumberOfArithmeticTriplets {

    public int arithmeticTriplets(int[] nums, int diff) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num-diff) && set.contains(num - diff*2)) {
                result++;
            }
            set.add(num);
        }
        return result;
    }
}
