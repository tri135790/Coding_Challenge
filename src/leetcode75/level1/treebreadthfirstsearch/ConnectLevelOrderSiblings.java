package leetcode75.level1.treebreadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

class TreeNodeWithLevel {
    int val;
    TreeNodeWithLevel left;
    TreeNodeWithLevel right;
    TreeNodeWithLevel next;

    TreeNodeWithLevel(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        TreeNodeWithLevel nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNodeWithLevel current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
};

class ConnectLevelOrderSiblings {
    public static void connect(TreeNodeWithLevel root) {
        Queue<TreeNodeWithLevel> queue = new LinkedList<>();
        if (root == null) return;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0 ; i < level; i++) {
                TreeNodeWithLevel current = queue.poll();
                if (i == level - 1) {
                    current.next = null;
                } else {
                    current.next = queue.peek();
                }

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNodeWithLevel root = new TreeNodeWithLevel(12);
        root.left = new TreeNodeWithLevel(7);
        root.right = new TreeNodeWithLevel(1);
        root.left.left = new TreeNodeWithLevel(9);
        root.right.left = new TreeNodeWithLevel(10);
        root.right.right = new TreeNodeWithLevel(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
