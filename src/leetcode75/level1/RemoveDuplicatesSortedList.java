package leetcode75.level1;

import leetcode75.level1.ListNode.ListNode;

public class RemoveDuplicatesSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode list = head;

        while (list.next != null) {

            if (list.val == list.next.val) {
                list.next = list.next.next;
                continue;
            }
            list = list.next;
        }
        return head;
    }
}
