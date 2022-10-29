package leetcode75.level1.dynamicprogramming;

public class LCSubsequence {

    public int findLCSLength(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public int findLCSLengthTopdown(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        return recursive(dp, s1,s2,0,0);
    }

    private int recursive(int[][] dp, String s1, String s2, int start1, int start2) {
        if (start1 == s1.length() || start2 == s2.length()) {
            return 0;
        }

        if (dp[start1][start2] == 0) {
            if (s1.charAt(start1) == s2.charAt(start2)) {
                dp[start1][start2] = 1 + recursive(dp, s1,s2,start1 +1,start2+1);
            }

            int c1 = recursive(dp, s1,s2,start1 + 1, start2);
            int c2 = recursive(dp, s1,s2,start1, start2 + 1);
            dp[start1][start2] = Math.max(dp[start1][start2], Math.max(c1,c2));
        }
        return dp[start1][start2];
    }


    public static void main(String[] args) {
        LCSubsequence lcs = new LCSubsequence();
        System.out.println(lcs.findLCSLengthTopdown("abdca", "cbda"));
        System.out.println(lcs.findLCSLengthTopdown("passport", "ppsspt"));
    }
}
