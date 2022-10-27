package leetcode75.level1.dynamicprogramming;

public class LPS {

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
            dp[start][end] = 2 + recursive(dp, st, start + 1, end - 1);
            return dp[start][end];
        }

        int c1 = recursive(dp, st, start + 1, end);
        int c2 = recursive(dp, st, start, end -1);

        dp[start][end] = Math.max(c1,c2);
        return dp[start][end];
    }

    public int findLPSLengthBottomUp(String st) {
        int[][] dp = new int[st.length()][st.length()];

        for (int i = 0; i < st.length(); i++) {
            dp[i][i] = 1;
        }

        for (int start = st.length() -1; start >= 0; start --) {
            for (int end = start + 1; end < st.length(); end ++) {
                if (st.charAt(start) == st.charAt(end)) {
                    dp[start][end] = 2 + dp[start+1][end - 1];
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }
        return dp[0][st.length()-1];
    }

    public static void main(String[] args) {
        LPS lps = new LPS();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}
