package leetcode75.level1.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        backtrack(s,result, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, List<List<String>> result, List<String> list) {
        if (s == null || s.length() == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if(!isPalindrome(temp)) continue; // only do backtracking when current string is palindrome

            list.add(temp);  // choose
            backtrack(s.substring(i, s.length()), result, list); // explore
            list.remove(list.size() - 1);
        }
        return;
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }
}
