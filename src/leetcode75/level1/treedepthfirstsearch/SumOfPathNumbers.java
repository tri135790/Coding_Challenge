package leetcode75.level1.treedepthfirstsearch;

class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {

        return backtrack(root, 0);
    }

    private static int backtrack(TreeNode node, int pathSum) {

        if (node == null)
            return 0;

        pathSum = 10 * pathSum + node.val;

        if (node.left == null && node.right == null) {
            return pathSum;
        } else {
            return backtrack(node.left, pathSum) + backtrack(node.right, pathSum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println(
            "Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
