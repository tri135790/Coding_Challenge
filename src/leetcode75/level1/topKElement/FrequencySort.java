package leetcode75.level1.topKElement;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public static String sortCharacterByFrequency(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char n : str.toCharArray())
            map.put(n, map.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
            new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        maxHeap.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> a = maxHeap.poll();
            int count = a.getValue();
            while (count > 0) {
                sb.append(a.getKey());
                count--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
