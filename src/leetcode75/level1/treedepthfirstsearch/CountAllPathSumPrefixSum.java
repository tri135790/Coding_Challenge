package leetcode75.level1.treedepthfirstsearch;

import java.util.HashMap;
import java.util.Map;

public class CountAllPathSumPrefixSum {

    public static int countPaths(TreeNode root, int targetSum) {
        // A map that stores the number of times a prefix sum has occurred so far.
        Map<Integer, Integer> map = new HashMap<>();

        return countPathsPrefixSum(root, targetSum, map, 0);
    }

    public static int countPathsPrefixSum(TreeNode node, int targetSum, Map<Integer, Integer> map, Integer currentPathSum) {
       if (node == null) {
            return 0;
       }

       int pathCount = 0;

       currentPathSum += node.val;

       if (currentPathSum == targetSum) pathCount++;

       pathCount += map.getOrDefault(currentPathSum - targetSum, 0);

       map.put(currentPathSum, map.getOrDefault(currentPathSum,0) + 1);

       pathCount += countPathsPrefixSum(node.left, targetSum, map, currentPathSum);
       pathCount += countPathsPrefixSum(node.right, targetSum, map, currentPathSum);

        map.put(currentPathSum, map.getOrDefault(currentPathSum,0) - 1);

        return pathCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(-1);
        root.left.left.left = new TreeNode(-1);
        root.left.left.left.left = new TreeNode(2);
        System.out.println("Tree has path: " + CountAllPathSumPrefixSum.countPaths(root, 2));
    }
}
