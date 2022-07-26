package leetcode75.level1;

import leetcode75.level1.ListNode.ListNode;

public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {

        ListNode oneStepPointer = head;
        ListNode twoStepPointer = head;

        while (twoStepPointer != null && twoStepPointer.next != null) {
            oneStepPointer = oneStepPointer.next;
            twoStepPointer = twoStepPointer.next.next;
        }

        return  oneStepPointer;
    }
}
