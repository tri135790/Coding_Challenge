package leetcode75.level1.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for (int n : nums) {

            int size = permutations.size();

            for (int i = 0 ; i < size; i++) {
                List<Integer> permutation = permutations.poll();

                for (int j = 0; j <= permutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(permutation);
                    newPermutation.add(j, n);
                    if (newPermutation.size() == nums.length) {
                        result.add(newPermutation);
                    } else {
                        permutations.add(newPermutation);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
