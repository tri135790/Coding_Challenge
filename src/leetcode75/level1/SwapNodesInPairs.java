package leetcode75.level1;

import leetcode75.level1.ListNode.ListNode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if ( head == null || head.next == null) return head;

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;

    }
}
