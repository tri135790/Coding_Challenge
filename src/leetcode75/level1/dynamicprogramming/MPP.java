package leetcode75.level1.dynamicprogramming;

public class MPP {

    public int findMPPCuts(String st) {
        boolean[][] isPalindrome = new boolean[st.length()][st.length()];

        for (int i = 0; i < st.length(); i++)
            isPalindrome[i][i] = true;

        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    if (endIndex - startIndex == 1 || isPalindrome[startIndex + 1][endIndex - 1]) {
                        isPalindrome[startIndex][endIndex] = true;
                    }
                }
            }
        }

        int[] cuts = new int[st.length()];
        for (int start = st.length()-1; start >= 0; start-- ) {
            int minCuts = Integer.MAX_VALUE;
            for (int end = st.length() - 1; end >= start; end--) {
                if (isPalindrome[start][end]) {
                    minCuts = (end == st.length() - 1) ? 0 : Math.min(minCuts, 1 + cuts[end + 1]);
                }
            }
            cuts[start] = minCuts;
        }

        return cuts[0];
    }

    private boolean isPalindrome(String st, int x, int y) {
        while(x < y) {
            if(st.charAt(x++) != st.charAt(y--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MPP mpp = new MPP();
        System.out.println(mpp.findMPPCuts("abcdef"));
        System.out.println(mpp.findMPPCuts("cdpdd"));
        System.out.println(mpp.findMPPCuts("pqr"));
        System.out.println(mpp.findMPPCuts("pp"));
    }
}
