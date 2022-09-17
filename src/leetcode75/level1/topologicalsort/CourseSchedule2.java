package leetcode75.level1.topologicalsort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CourseSchedule2 {

    boolean isPossible;

    public int[] findOrderKahn(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();

        int[] topologicalOrder = new int[numCourses];

        for (int[] pair : prerequisites) {
            incomingEdges[pair[0]]++;

            if (!map.containsKey(pair[1])) {
                List<Integer> list = new LinkedList<>();
                list.add(pair[0]);
                map.put(pair[1], list);
            } else {
                map.get(pair[1]).add(pair[0]);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }
        int i = 0;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            topologicalOrder[i] = current;
            i++;

            if (map.containsKey(current)) {
                for (int course : map.get(current)) {
                    incomingEdges[course]--;
                    if (incomingEdges[course] == 0) {
                        queue.add(course);
                    }
                }
            }
        }

        if (i == numCourses) {
            return topologicalOrder;
        }

        return new int[0];

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visisted = new int[numCourses];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        List<Integer> resultList = new LinkedList<>();

        this.isPossible = true;

        for (int[] pair : prerequisites) {
            if (!map.containsKey(pair[1])) {
                List<Integer> list = new LinkedList<>();
                list.add(pair[0]);
                map.put(pair[1], list);
            } else {
                map.get(pair[1]).add(pair[0]);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (visisted[i] == 0) {
                dfs(i, visisted, map, resultList);
            }
        }

        int[] result;

        if (isPossible) {
            result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[0] = resultList.get(numCourses - i - 1);
            }
        } else {
            result = new int[0];
        }

        return result;

    }

    private void dfs(
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

}
