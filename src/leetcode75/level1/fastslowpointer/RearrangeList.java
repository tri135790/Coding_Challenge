package leetcode75.level1.fastslowpointer;

import java.util.List;

public class RearrangeList {

    public static void reorder(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow);
        ListNode headFirstHalf = head;
        while (headFirstHalf != null && headSecondHalf!= null) {
            ListNode next = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = next;

            next = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = next;
        }

        if (headFirstHalf != null)
            headFirstHalf.next = null;


    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
