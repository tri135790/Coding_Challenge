package leetcode75.level1.dynamicprogramming;

public class EditDistance {

    public int findMinOperations(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        return recursive(dp, s1,s2,0,0);
    }

    private int recursive(int[][] dp, String s1, String s2, int start1, int start2) {
        if (start1 == s1.length()) {
            return s2.length() - start2;
        }

        if (start2 == s2.length()) {
            return s1.length() - start1;
        }

        if (dp[start1][start2] == 0) {
            if (s1.charAt(start1) == s2.charAt(start2)) {
                dp[start1][start2] = recursive(dp, s1,s2,start1 + 1, start2 + 1);
            } else {
                int c1 = 1 + recursive(dp,s1,s2,start1 + 1, start2);
                int c2 = 1 + recursive(dp, s1,s2,start1, start2 + 1);
                int c3 = 1 + recursive(dp, s1,s2, start1 + 1, start2 + 1);
                dp[start1][start2] = Math.min(c1,Math.min(c2,c3));
            }
        }

        return dp[start1][start2];
    }

    public int findMinOperationsBottomUp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j<=s2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1 ; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int c1 = 1 + dp[i-1][j-1];
                    int c2 = 1 + dp[i][j-1];
                    int c3 = 1 + dp[i-1][j];
                    dp[i][j] = Math.min(c1,Math.min(c2,c3));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        EditDistance editDisatnce = new EditDistance();
        System.out.println(editDisatnce.findMinOperationsBottomUp("bat", "but"));
        System.out.println(editDisatnce.findMinOperationsBottomUp("abdca", "cbda"));
        System.out.println(editDisatnce.findMinOperationsBottomUp("passpot", "ppsspqrt"));
    }
}
