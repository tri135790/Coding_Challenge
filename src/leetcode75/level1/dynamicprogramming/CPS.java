package leetcode75.level1.dynamicprogramming;

public class CPS {

    public int findCPS(String st) {
        boolean[][] dp = new boolean[st.length()][st.length()];
        int count = 0;

        for (int i = 0; i < st.length(); i++) {
            count++;
            dp[i][i] = true;
        }

        for (int start = st.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end < st.length(); end++) {
                if (st.charAt(start) == st.charAt(end)) {
                    if (end - start == 1 || dp[start + 1][end -1]) {
                        count++;
                        dp[start][end] = true;
                    }
                }
            }
        }

        return count;
    }



    public static void main(String[] args) {
        CPS cps = new CPS();
        System.out.println(cps.findCPS("abdbca"));
        System.out.println(cps.findCPS("cdpdd"));
        System.out.println(cps.findCPS("pqr"));
    }
}
