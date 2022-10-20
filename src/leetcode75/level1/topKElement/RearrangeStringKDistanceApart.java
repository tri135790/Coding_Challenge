package leetcode75.level1.topKElement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringKDistanceApart {

    public static String reorganizeString(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();

        for (char a : str.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
            new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder sb = new StringBuilder(str.length());

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            // append the current character to the result string and decrement its count
            sb.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            queue.offer(currentEntry);
            if (queue.size() == k) {
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue() > 0)
                    maxHeap.add(entry);
            }
        }

        return sb.length() == str.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}
