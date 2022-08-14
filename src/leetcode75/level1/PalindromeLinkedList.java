package leetcode75.level1;

import leetcode75.level1.ListNode.ListNode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast =fast.next.next;
            slow = slow.next;
        }

        if (fast!= null) {
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
