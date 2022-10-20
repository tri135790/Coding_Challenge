package leetcode75.level1.topKElement;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

    public static int scheduleTasks(char[] tasks, int k) {
        Map<Character, Integer> map = new HashMap<>();

        for (char a : tasks) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
            new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        maxHeap.addAll(map.entrySet());

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        Map.Entry<Character, Integer> previousEntry = null;
        int count = 0;

        while (!maxHeap.isEmpty()) {
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            int n = k + 1; // try to execute as many as 'k+1' tasks from the max-heap
            for (; n > 0 && !maxHeap.isEmpty(); n--) {
                count++;
                Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
                if (currentEntry.getValue() > 1) {
                    currentEntry.setValue(currentEntry.getValue() - 1);
                    waitList.add(currentEntry);
                }
            }
            maxHeap.addAll(waitList); // put all the waiting list back on the heap
            if (!maxHeap.isEmpty())
                count += n; // we'll be having 'n' idle intervals for the next iteration
        }

        return count;
    }

    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
    }

}
