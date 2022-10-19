package leetcode75.level1.topKElement;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {

    public static String rearrangeString(String str) {

        Map<Character, Integer> map = new HashMap<>();

        for (char a : str.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
            new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder sb = new StringBuilder(str.length());

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();

            if (previousEntry != null && previousEntry.getValue() > 0) {
                maxHeap.add(previousEntry);
            }
            sb.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            previousEntry = currentEntry;
        }

        return sb.length() == str.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}
