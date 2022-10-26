package leetcode75.level1.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int count = 0;

        for (int end = 0 ; end < str.length(); end++) {
            map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0) + 1);
            while (map.size() > k) {
                map.put(str.charAt(start), map.get(str.charAt(start))-1);
                if (map.get(str.charAt(start)) == 0) {
                    map.remove(str.charAt(start));
                }
                start++;
            }

            count = Math.max(count, end - start + 1);

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 10));
    }
}
