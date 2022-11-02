package leetcode75.level1.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class NumberMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {

        Map<String,Integer> map = new HashMap<>();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        int count = 0;

        for (String str : map.keySet()) {
            int i = 0, j = 0;

            while ( i < s.length() && j < str.length()) {
                if (s.charAt(i) == str.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }

            if (j == str.length()) {
                count += map.get(str);
            }
        }

        return count;
    }


    public static void main(String[] args) {
        NumberMatchingSubsequences si = new NumberMatchingSubsequences();
        String[] words = {"a","bb","acd","ace"};
        System.out.println(si.numMatchingSubseq("abcde",words));
    }
}
