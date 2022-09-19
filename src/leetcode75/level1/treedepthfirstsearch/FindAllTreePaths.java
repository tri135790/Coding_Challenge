package leetcode75.level1.treedepthfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new LinkedList<>();

        if (root == null) return  allPaths;

        backtrack(root, path, allPaths, sum);
        return allPaths;
    }

    private static void backtrack(TreeNode node, List<Integer> path, List<List<Integer>> allPaths
        , int sum) {
        path.add(node.val);
        if (sum - node.val == 0 && node.left == null && node.right == null) {
            allPaths.add(new LinkedList<>(path));
        }

        if (node.left != null) {
            backtrack(node.left, path, allPaths, sum - node.val);
        }

        if (node.right != null) {
            backtrack(node.right, path, allPaths, sum - node.val);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
