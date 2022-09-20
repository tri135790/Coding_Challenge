package leetcode75.level1.treedepthfirstsearch;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class CountAllPathSum {

    public static int countPaths(TreeNode root, int S) {
        List<Integer> path = new LinkedList<>();
        return countPathsRecursive(root, S, path);
    }

    private static int countPathsRecursive(TreeNode node, int S, List<Integer> path) {
        if (node == null)
            return 0;

        path.add(node.val);

        int pathSum = 0; int count = 0;

        for (int i = path.size() - 1; i >= 0; i--) {
            pathSum += path.get(i);
            if (pathSum == S) {
                count++;
            }
        }

        count += countPathsRecursive(node.left, S, path);
        count += countPathsRecursive(node.right, S, path);

        path.remove(path.size() - 1);
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.left = new TreeNode(1000000000);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
