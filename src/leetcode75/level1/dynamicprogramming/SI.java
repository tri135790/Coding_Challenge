package leetcode75.level1.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class SI {

    public boolean findSI(String m, String n, String p) {
        Map<String, Boolean> dp = new HashMap<>();
        return recursive(dp, m,n,p,0,0,0);
    }

    private boolean recursive(Map<String, Boolean> dp,String m, String n, String p, int i1, int i2,
                               int i3) {
        if (i1 == m.length() && i2 == n.length() && i3 == p.length()) {
            return true;
        }

        if (i3 == p.length()) {
            return false;
        }

        String subProblemKey = i1 + "-" + i2 + "-" + i3;
        if (!dp.containsKey(subProblemKey)) {
            boolean b1 = false, b2 = false;
            if (i1 < m.length() && p.charAt(i3) == m.charAt(i1)) {
                b1 = recursive(dp,m,n,p,i1 + 1, i2,i3 +1);
            }
            if (i2 < n.length() && p.charAt(i3) == n.charAt(i2)) {
                b2 = recursive(dp,m,n,p,i1, i2 + 1,i3 +1);
            }

            dp.put(subProblemKey, b1 || b2);
        }

        return dp.get(subProblemKey);
    }

    public static void main(String[] args) {
        SI si = new SI();
        System.out.println(si.findSI("abd", "cef", "abcdef"));
        System.out.println(si.findSI("abd", "cef", "adcbef"));
        System.out.println(si.findSI("abc", "def", "abdccf"));
        System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));
    }
}
