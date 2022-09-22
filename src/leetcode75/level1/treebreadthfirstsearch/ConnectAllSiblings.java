package leetcode75.level1.treebreadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

class ConnectAllSiblings {
    public static void connect(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return;

        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);

            if (queue.peek() != null) current.next = queue.peek();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNode current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
