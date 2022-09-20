package leetcode75.level1.treedepthfirstsearch;

public class MaximumPathSum {

    private static int maxSum = Integer.MIN_VALUE;

    public static int findMaximumPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private static int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int maxLeft = dfs(node.left);
        int maxRight = dfs(node.right);
        int maxNode = Math.max(maxLeft, maxRight);

        maxSum = Math.max(maxSum, Math.max(node.val, Math.max(node.val + maxLeft + maxRight,
            node.val + maxNode
        )));

        return Math.max(node.val, maxNode + node.val);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}
