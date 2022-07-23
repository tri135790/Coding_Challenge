package leetcode75.level1;

import leetcode75.level1.ListNode.ListNode;

public class ReversedLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        return  reverseHelper(head, null);
    }

    private ListNode reverseHelper(ListNode head, ListNode previousTemp) {
        if (head.next == null) {
            head.next = previousTemp;
            return head;
        }
        ListNode nextNode = head.next;
        head.next = previousTemp;
        return reverseHelper(nextNode, head);
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
}
