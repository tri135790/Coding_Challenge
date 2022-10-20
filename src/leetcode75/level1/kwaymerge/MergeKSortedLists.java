package leetcode75.level1.kwaymerge;

import java.util.PriorityQueue;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

public class MergeKSortedLists {

    public static ListNode merge(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.value - b.value);

        for (ListNode node : lists) {
            if (node != null)
            minHeap.add(node);
        }

        ListNode head = null;
        ListNode tail = null;

        while (!minHeap.isEmpty()) {
            ListNode current = minHeap.poll();

            if (head == null) {
                head = current;
                tail = current;
            } else {
                tail.next = current;
                tail = tail.next;
            }

            if (current.next != null) {
                minHeap.add(current.next);
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
