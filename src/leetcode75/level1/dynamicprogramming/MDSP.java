package leetcode75.level1.dynamicprogramming;

public class MDSP {

    public int findMinimumDeletions(String st) {
        return st.length - recursive(st,0, st.length()-1);
    }

    private int recursive(String st, int start, int end) {
        int min = Integer.MAX_VALUE;
        if (start >= end) {
            return 0;
        }

        if (st.charAt(start) == st.charAt(end)) {
            return recursive(st, start + 1, end - 1);
        }

        int c1 = 1 + recursive(st, start + 1, end);
        int c2 = 1 + recursive(st,start, end-1);
        return Math.min(c1,c2);
    }

    public int findMinimumDeletionsBottomUp(String st) {
        int[][] dp = new int[st.length()][st.length()];

        for (int i =0; i < st.length(); i++) {
            dp[i][i] = 0;
        }

        for (int start = st.length()-1; start >= 0; start--) {
            for (int end = start + 1; end < st.length(); end++) {
                if (st.charAt(start) == st.charAt(end)) {
                    dp[start][end] = dp[start+ 1][end-1];
                } else {
                    dp[start][end] = 1 + Math.min(dp[start+1][end], dp[start][end-1]);
                }
            }
        }

        return dp[0][st.length()-1];
    }

    public static void main(String[] args) {
        MDSP mdsp = new MDSP();
        System.out.println(mdsp.findMinimumDeletionsBottomUp("abdbca"));
        System.out.println(mdsp.findMinimumDeletionsBottomUp("cddpd"));
        System.out.println(mdsp.findMinimumDeletionsBottomUp("pqr"));
    }
}
