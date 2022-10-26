package leetcode75.level1.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {

        Map<Character, Integer> map = new HashMap<>();

        for (char i : pattern.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int start = 0;
        int matched = 0;

        for (int end =0; end < str.length(); end++) {
            Character current = str.charAt(end);

            if (map.containsKey(current)) {
                map.put(current, map.get(current) - 1);
                if (map.get(current) == 0) {
                    matched++;
                }
            }

            if (matched == map.size()) {
                return true;
            }

            if (end >= pattern.length() - 1) {
                Character leftChar = str.charAt(start);
                start++;
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matched--;
                    }
                    map.put(leftChar, map.get(leftChar) +1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
    }
}
