package leetcode75.level1.twoheaps;

import java.util.PriorityQueue;

class Interval {
    int start = 0;
    int end = 0;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class NextInterval {

    public static int[] findNextInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];

        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(intervals.length,
            (a,b) -> intervals[b].start - intervals[a].start);
        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(intervals.length,
            (a,b) -> intervals[b].end - intervals[a].end);

        for(int i = 0; i < intervals.length; i ++) {
            maxEndHeap.add(i);
            maxStartHeap.add(i);
        }

        while (!maxEndHeap.isEmpty()) {
            int nextInterval = -1;

            if (intervals[maxStartHeap.peek()].start >= intervals[maxEndHeap.peek()].end) {
                while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[maxEndHeap.peek()].end) {
                    nextInterval = maxStartHeap.poll();
                }
                maxStartHeap.add(nextInterval);
            }

            result[maxEndHeap.poll()] = nextInterval;
        }

        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(1, 12), new Interval(2, 9),
            new Interval(3, 10), new Interval(13, 14), new Interval(15, 16),
            new Interval(16, 17)
        };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}
