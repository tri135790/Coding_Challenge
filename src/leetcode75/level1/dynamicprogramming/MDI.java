package leetcode75.level1.dynamicprogramming;

public class MDI {

    public void findMDI(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        int c1 = dp[s1.length()][s2.length()];
        System.out.println("Minimum deletions needed: " + (s1.length() - c1));
        System.out.println("Minimum insertions needed: " + (s2.length() - c1));
    }


    public static void main(String[] args) {
        MDI mdi = new MDI();
        mdi.findMDI("abc", "fbc");
        mdi.findMDI("abdca", "cbda");
        mdi.findMDI("passport", "ppsspt");
    }
}
