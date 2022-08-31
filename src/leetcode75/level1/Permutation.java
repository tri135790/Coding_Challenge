package leetcode75.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

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

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
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
        int[] test = new int[]{1,2,3};
        permute(test);
    }


}
