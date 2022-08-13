package leetcode75.level1;

import leetcode75.level1.ListNode.ListNode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode list = new ListNode();
        list.next = head;
        ListNode ans = list;

        while (list.next != null) {
            if (list.next.val == val) {
                list.next = list.next.next;
            }
            list = list.next;
        }

        return ans;
    }

    //review
    public ListNode version2(ListNode head, int val) {
        if (head == null) return null;
        head.next = version2(head.next, val);
        return head.val == val ? head.next : head;
    }
}
