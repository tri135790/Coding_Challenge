package leetcode75.level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutation2 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] board = new int[nums.length];
        backtracking(nums, board, 0, res);
        return res;
    }

    private static void backtracking(int[] nums, int[] board, int count, List<List<Integer>> res) {

        if (count == nums.length) {
            res.add(construct(board));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1 && !set.contains(nums[i])) {
                set.add(nums[i]);
                board[count] = nums[i];
                nums[i] = -1;
                backtracking(nums,board, count + 1, res);
                nums[i] = board[count];
            }
        }
    }

    private static List<Integer> construct(int[] board) {
        List<Integer> list = new LinkedList<>();
        for (int i =0; i < board.length; i++) {
            list.add(board[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        permute(new int[] {1,1,2});
    }
}
