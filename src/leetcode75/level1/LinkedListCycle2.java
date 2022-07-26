package leetcode75.level1;

import leetcode75.level1.ListNode.ListNode;

public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow= slow.next;
                    slow2 = slow2.next;
                }
                return  slow2;
            }
        }
        return null;
    }
}
