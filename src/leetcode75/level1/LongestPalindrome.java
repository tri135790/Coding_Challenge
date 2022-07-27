package leetcode75.level1;

import java.util.HashMap;
import java.util.HashSet;

public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bananas"));
    }
}
