package leetcode75.level1.dynamicprogramming;

public class LCS {

    public int findLCSLength(String s1, String s2) {
        int maxLength = Math.min(s1.length(), s2.length());
        int[][][] dp = new int[s1.length()][s2.length()][maxLength];
        return recursive(dp,s1,s2,0,0,0);
    }

    private int recursive(int[][][] dp, String s1, String s2, int start1, int start2, int count) {
        if (start1 == s1.length() || start2 == s2.length()) {
            return count;
        }

        if (dp[start1][start2][count] == 0) {
            int c3 = count;
            if (s1.charAt(start1) == s2.charAt(start2)) {
                c3 = recursive(dp, s1,s2,start1 + 1, start2 + 1, count + 1);
            }

            int c1 = recursive(dp, s1,s2,start1 + 1, start2, 0);
            int c2 = recursive(dp, s1,s2,start1, start2 + 1, 0);
            dp[start1][start2][count] = Math.max(c3, Math.max(c1,c2));
        }
        return dp[start1][start2][count];
    }

    public int findLCSLengthBottomUp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println(lcs.findLCSLengthBottomUp("abdca", "cbda"));
        System.out.println(lcs.findLCSLengthBottomUp("passport", "ppsspt"));
    }
}
