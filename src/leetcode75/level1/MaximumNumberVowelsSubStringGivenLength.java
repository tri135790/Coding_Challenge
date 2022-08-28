package leetcode75.level1;

public class MaximumNumberVowelsSubStringGivenLength {

    public static int maxVowels(String s, int k) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < k; i ++) {
            if (isVowels(s.charAt(i))) {
                count++;
            }
        }
        max = count;

        for (int i = k ;i < s.length(); i++) {
            if (isVowels(s.charAt(i))) {
                count++;
            }
            if (isVowels(s.charAt(i-k))) {
                count--;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    private static boolean isVowels(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a =='u' || a =='o') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33);
    }
}
