package leetcode75.level1.treebreadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

class MinimumBinaryTreeDepth {

    public static int findDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return 0;

        queue.offer(root);

        int minDepth = 0;

        while (!queue.isEmpty()) {
            int level = queue.size();
            minDepth++;
            for (int i = 0 ; i < level; i++) {
                TreeNode current = queue.poll();

                if (current.left == null && current.right == null) return minDepth;

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return minDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}
