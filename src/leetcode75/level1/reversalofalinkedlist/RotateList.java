package leetcode75.level1.reversalofalinkedlist;

public class RotateList {

    public static ListNode rotate(ListNode head, int rotations) {
        int length = 0;
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            previous = current;
            current = current.next;
            length++;
        }
        ListNode last = previous;
        current = head;

        int x = rotations%length;

        if (length - x == 0) return head;

        for (int i = 0 ; i < length - x; i++) {
            previous = current;
            current = current.next;
        }
        last.next = head;
        head = current;
        previous.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = RotateList.rotate(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
