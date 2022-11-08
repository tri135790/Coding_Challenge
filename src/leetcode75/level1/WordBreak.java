package leetcode75.level1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return recursive(s, wordSet, 0, dp);
    }

    private boolean recursive(String s, Set<String> wordSet, int current, Boolean[] dp) {

        if (current == s.length()) {
            return true;
        }

        if (dp[current] == null) {
            boolean result = false;

            for (int i = current + 1; i <= s.length(); i++) {
                String currentWord = s.substring(current, i);
                if (!wordSet.contains(currentWord)) {
                    continue;
                }
                if (recursive(s, wordSet, i, dp)) {
                    result = true;
                    break;
                }
            }
            dp[current] = result;
        }
        return dp[current];
    }
}
