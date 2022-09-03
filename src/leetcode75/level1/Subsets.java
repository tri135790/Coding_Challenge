package leetcode75.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr) {{
                    add(num);
                }});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    public static List<List<Integer>> subsetsBackTrack(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k <= nums.length; k++) {
            backtrack(result, new LinkedList<>(), k, nums, 0);
        }
        return result;
    }

    private static void backtrack(
        List<List<Integer>> result, List<Integer> list, int k,
        int[] nums, int count
    ) {
        if (list.size() == k) {
            result.add(new LinkedList<>(list));
            return;
        }

        for (int i = count; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(result, list, k, nums, count + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        subsetsBackTrack(new int[]{1, 2, 3});
    }

}
