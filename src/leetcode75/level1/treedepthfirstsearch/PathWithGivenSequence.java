package leetcode75.level1.treedepthfirstsearch;

public class PathWithGivenSequence {

    public static boolean findPath(TreeNode root, int[] sequence) {
        // TODO: Write your code here
        if (sequence.length == 0) return true;

        return check(root, sequence, 0);
    }

    private static boolean check(TreeNode node, int[] sequence, int counter) {
        if (node == null) return false;

        if (node.val != sequence[counter]  || counter >= sequence.length) return false;

        if (node.left == null && node.right == null && counter == sequence.length - 1) return true;

        return check(node.left, sequence, counter + 1) || check(node.right, sequence, counter + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
