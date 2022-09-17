package leetcode75.level1.topologicalsort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {

    public static String findOrder(String[] words) {

        //initialize the graph
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> incomingEdges = new HashMap<>();
        for (String word : words) {
            for (Character letter : word.toCharArray()) {
                incomingEdges.put(letter, 0);
                graph.put(letter, new LinkedList<>());
            }
        }

        //build the graph
        for (int i =0; i < words.length-1; i++) {
            String parent = words[i];
            String children = words[i + 1];

            for (int j = 0; j < Math.min(parent.length(), children.length()); j++) {
                Character char1 = parent.charAt(j);
                Character char2 = children.charAt(j);
                if (char1 != char2) {
                    incomingEdges.put(char2, incomingEdges.get(char2) + 1);
                    graph.get(char1).add(char2);
                    break;
                }
            }
        }

        //Using queue
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer>  set : incomingEdges.entrySet()) {
            if (set.getValue() == 0) {
                queue.add(set.getKey());
            }
        }

        //Topological Sort
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            Character current = queue.poll();
            stringBuilder.append(current);

            for (Character a : graph.get(current)) {
                incomingEdges.put(a, incomingEdges.get(a) - 1);
                if (incomingEdges.get(a) == 0) {
                    queue.add(a);
                }
            }
        }

        return stringBuilder.length() == incomingEdges.size() ? stringBuilder.toString() : "";
    }

    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);
    }
}
