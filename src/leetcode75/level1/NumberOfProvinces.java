package leetcode75.level1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

    public int findCircleNumBFS(int[][] isConnected) {
        boolean[] isVisited = new boolean[isConnected.length];

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i =0; i < isConnected.length; i++) {
            if (!isVisited[i]) {
                int current;
                queue.offer(i);
                isVisited[i] = true;

                while (!queue.isEmpty()) {
                    current = queue.poll();

                    for (int j = i+1; j < isConnected[current].length; j ++) {
                        if (isConnected[current][j] == 1 && !isVisited[j]) {
                            queue.offer(j);
                            isVisited[j] = true;
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    public int findCircleNumDFS(int[][] M) {
        boolean[] visited = new boolean[M.length]; //visited[i] means if ith person is visited in this algorithm
        int count = 0;
        for(int i = 0; i < M.length; i++) {
            if(!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] M, boolean[] visited, int person) {
        for(int other = 0; other < M.length; other++) {
            if(M[person][other] == 1 && !visited[other]) {
                //We found an unvisited person in the current friend cycle
                visited[other] = true;
                dfs(M, visited, other); //Start DFS on this new found person
            }
        }
    }
}
