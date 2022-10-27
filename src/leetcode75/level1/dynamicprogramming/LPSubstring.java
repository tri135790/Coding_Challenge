package leetcode75.level1.dynamicprogramming;

public class LPSubstring {

    public int findLPSLength(String st) {
        int[][] dp = new int[st.length()][st.length()];
        return recursive(dp, st, 0, st.length() - 1);
    }

    private int recursive(int[][] dp, String st, int start, int end) {
        if (start > end) {
            return 0;
        }

        if (start == end) {

            return 1;
        }

        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        if (st.charAt(start) == st.charAt(end)) {
            int count = recursive(dp, st,start + 1, end - 1);
            if (count == end - start - 1) {
                dp[start][end] = 2 + count;
                return dp[start][end];
            }
        }

        int c1 = recursive(dp, st, start + 1, end);
        int c2 = recursive(dp, st, start, end - 1);
        dp[start][end] = Math.max(c1,c2);
        return dp[start][end];
    }

    public int findLPSLengthBottomUp(String st) {
        int[][] dp = new int[st.length()][st.length()];

        for (int i = 0; i < st.length();i++) {
            dp[i][i] = 1;
        }

        for (int start = st.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end < st.length(); end++) {
                if (st.charAt(start) == st.charAt(end) && dp[start + 1][end-1] == end - start - 1) {
                    dp[start][end] = 2 + dp[start + 1][end-1];
                } else {
                    int c1 = dp[start + 1][end];
                    int c2 = dp[start][end-1];
                    dp[start][end] = Math.max(c1,c2);
                }
            }
        }

        return dp[0][st.length() - 1];
    }

    public static void main(String[] args) {
        LPSubstring lps = new LPSubstring();
        System.out.println(lps.findLPSLengthBottomUp("abdbca"));
        System.out.println(lps.findLPSLengthBottomUp("cddpd"));
        System.out.println(lps.findLPSLengthBottomUp("pqr"));
    }
}
