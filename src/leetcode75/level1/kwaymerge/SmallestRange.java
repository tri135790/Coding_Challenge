package leetcode75.level1.kwaymerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange {

    public static int[] findSmallestRange(List<Integer[]> lists) {

        PriorityQueue<Node> minHeap =
            new PriorityQueue<>((a,b) -> lists.get(a.arrayIndex)[a.elementIndex] - lists.get(b.arrayIndex)[b.elementIndex]);

        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            minHeap.add(new Node(0, i));
            maxNumber = Math.max(maxNumber, lists.get(i)[0]);
        }

        int start = 0, end = Integer.MAX_VALUE;
        while (minHeap.size() == lists.size()) {
            Node current = minHeap.poll();
            if ((end-start) >= maxNumber - lists.get(current.arrayIndex)[current.elementIndex]) {
                end = maxNumber;
                start = lists.get(current.arrayIndex)[current.elementIndex];
            }
            current.elementIndex++;
            if (current.elementIndex < lists.get(current.arrayIndex).length) {
                minHeap.add(current);
                maxNumber = Math.max(maxNumber,
                    lists.get(current.arrayIndex)[current.elementIndex]);
            }
        }

        return new int[] { start, end };
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 1, 5, 8 };
        Integer[] l2 = new Integer[] { 4, 12 };
        Integer[] l3 = new Integer[] { 7, 8, 10 };
        List<Integer[]> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}
