package leetcode75.level1.kwaymerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int elementIndex;
    int arrayIndex;

    Node(int elementIndex, int arrayIndex) {
        this.elementIndex = elementIndex;
        this.arrayIndex = arrayIndex;
    }
}

public class KthSmallestInMSortedArrays {


    public static int findKthSmallest(List<Integer[]> lists, int k) {

        PriorityQueue<Node> minHeap =
            new PriorityQueue<>((a,b) -> lists.get(a.arrayIndex)[a.elementIndex] - lists.get(b.arrayIndex)[b.elementIndex]);

        for (int i = 0; i < lists.size(); i++) {
            minHeap.add(new Node(0,i));
        }
        int count = 0;
        while(!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            count++;
            if (count == k) {
                return lists.get(current.arrayIndex)[current.elementIndex];
            }
            current.elementIndex++;
            if (current.elementIndex < lists.get(current.arrayIndex).length) {
                minHeap.add(current);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
