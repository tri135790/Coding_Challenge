package leetcode75.level1;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int counter_s = 0;

        if (s.length() == 0) {
            return true;
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(counter_s)) {
                counter_s ++;
            }
            if (counter_s == s.length()) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "c";
        String t = "cccc";
        System.out.println(isSubsequence(s,t));

    }
}
