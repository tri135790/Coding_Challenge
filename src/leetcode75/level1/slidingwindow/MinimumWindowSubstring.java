package leetcode75.level1.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String findSubstring(String str, String pattern) {

        Map<Character, Integer> map = new HashMap<>();

        for (char i : pattern.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int start = 0;
        int matched = 0;
        int minLength = str.length() + 1;
        int subStrStart = 0;

        for (int end = 0; end < str.length(); end++) {
            Character current = str.charAt(end);

            if (map.containsKey(current)) {
                map.put(current, map.get(current)-1);
                if (map.get(current) == 0) {
                    matched++;
                }
            }

            while (matched == map.size()) {

                if (minLength > end - start + 1) {
                    minLength = end - start + 1;
                    subStrStart = start;
                }

                Character leftChar = str.charAt(start);
                start++;
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matched--;
                    }
                    map.put(leftChar,map.get(leftChar) + 1);
                }
            }
        }

        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }
    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abac"));
        System.out.println(MinimumWindowSubstring.findSubstring("abdbca", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
    }
}
