package leetcode75.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String t) {
        List<Integer> list = new LinkedList<>();

        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return list;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int begin = 0, end = 0;
        int counter = map.size();

        while (end < s.length()) {
            char c = s.charAt(end);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    counter--;
                }
            }
            end ++;

            while (counter == 0) {
                char beginChar = s.charAt(begin);

                if (map.containsKey(beginChar)) {
                    map.put(beginChar, map.get(beginChar) + 1);
                    if (map.get(beginChar) > 0) {
                        counter++;
                    }
                }
                if (end - begin == t.length()) {
                    list.add(begin);
                }
                begin ++;
            }
        }
        return list;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> soln = new LinkedList<>();

        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()){
            return soln;
        }

        int[] chars = new int[26];
        for (Character c : p.toCharArray()){
            chars[c-'a']++;
        }

        int start = 0, end = 0, len = p.length(), diff = len;

        char temp;

        for (end = 0; end < len; end++){
            temp = s.charAt(end);

            chars[temp-'a']--;

            if (chars[temp-'a'] >= 0){
                diff--;
            }
        }

        if (diff == 0){
            soln.add(0);
        }

        while (end < s.length()){


            temp = s.charAt(start);

            //If it's not negative, this means that the character WAS part of the anagram. That means we
            //are one step "farther away" from completing an anagram. So we must increment diff.
            if (chars[temp-'a'] >= 0){
                diff++;
            }

            chars[temp-'a']++;

            start++;

            temp = s.charAt(end);

            //Decrement hash value for this character, because it is now a part of the window
            chars[temp-'a']--;

            //Again, if it's not negative it is part of the anagram. So decrement diff
            if (chars[temp-'a'] >= 0){
                diff--;
            }

            //If diff has reached zero, that means for the last p.length() iterations, diff was decremented and
            //NOT decremented, which means every one of those characters was in the anagram, so it must be an anagram

            //Note: If many windows in a row find anagrams, then each iteration will have diff incremented then decremented again
            if (diff == 0){
                soln.add(start);
            }

            //Increment for next iteration
            end++;

        }

        return soln;
    }

    public static void main(String[] args) {
        findAnagrams2("aabcd","abc");
    }
}
