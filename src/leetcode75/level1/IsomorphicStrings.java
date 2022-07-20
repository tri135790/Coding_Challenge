package leetcode75.level1;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() == t.length()) {
            Map<Character, Character> mapStoT = new HashMap<>();
            Map<Character, Character> mapTtoS = new HashMap<>();
            for (int i = 0 ; i < s.length(); i++) {
                if (!mapStoT.containsKey(s.charAt(i))) {
                    mapStoT.put(s.charAt(i), t.charAt(i));
                    if (mapTtoS.containsKey(t.charAt(i))) {
                        return false;
                    }
                    mapTtoS.put(t.charAt(i), s.charAt(i));
                } else {
                    if (!mapStoT.get(s.charAt(i)).equals(t.charAt(i))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc","baba"));
    }
}
