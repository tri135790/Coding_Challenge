package leetcode75.level1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FindIfPathExistsInGraph {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graph = new HashSet[n];

        for (int i = 0; i < n ; i++) {
            graph[i] = new HashSet<>();
        }

        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        if (graph[source].contains(destination)) {
            return true;
        }

        Queue<Integer> queue = new LinkedList<>();
        int current;

        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current == destination) {
                return true;
            }

            for (Integer neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};

        validPath(6, edges, 0, 5);

    }
}
