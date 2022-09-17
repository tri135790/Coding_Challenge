package leetcode75.level1.topologicalsort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSort2 {

    private static boolean isPossible = true;

    public static List<Integer> sort(int vertices, int[][] edges) {
        int[] visisted = new int[vertices];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        List<Integer> resultList = new LinkedList<>();

        for (int[] pair : edges) {
            if (!map.containsKey(pair[1])) {
                List<Integer> list = new LinkedList<>();
                list.add(pair[0]);
                map.put(pair[1], list);
            } else {
                map.get(pair[1]).add(pair[0]);
            }
        }

        for (int i = 0; i < vertices; i++) {
            if (visisted[i] == 0) {
                dfs(i, visisted, map, resultList);
            }
        }

        List<Integer> result = new LinkedList<>();

        if (isPossible) {
            for (int i = 0; i < vertices; i++) {
                result.add(resultList.get(vertices - i - 1));
            }
        }

        return result;
    }

    private static void dfs(
        int i, int[] visited, HashMap<Integer, List<Integer>> map,
        List<Integer> resultList
    ) {
        if (!isPossible) {
            return;
        }
        visited[i] = -1;

        if (map.containsKey(i)) {
            for (int j : map.get(i)) {
                if (visited[j] == 0) {
                    dfs(j, visited, map, resultList);
                } else if (visited[j] == -1) {
                    isPossible = false;
                }
            }
        }

        visited[i] = 1;
        resultList.add(i);
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort2.sort(4,
            new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort2.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
            new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort2.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
            new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}
