package leetcode75.level1.dynamicprogramming;

public class SubsequencePatternMatching {



    public int findSPMCount(String str, String pat) {
        return recursive( str, pat, 0,0);
    }

    private int recursive(String str, String pat, int currentIndex, int currentPat) {
        if (currentPat == pat.length()) {
                return 1;
        }

        if (currentIndex == str.length()) {
            return 0;
        }

        if (str.charAt(currentIndex) == pat.charAt(currentPat - 1)) {

        }

        if (str.charAt(currentIndex) == pat.charAt(currentPat)) {
            return recursive(str,pat, currentIndex +1, currentPat + 1);
        }

        return dp[currentIndex][currentPat];
    }

    public static void main(String[] args) {
        SubsequencePatternMatching spm = new SubsequencePatternMatching();
        System.out.println(spm.findSPMCount("rabbbit", "rabbit"));
        System.out.println(spm.findSPMCount("babgbag", "bag"));
    }
}
