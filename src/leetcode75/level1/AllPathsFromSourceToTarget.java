package leetcode75.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
            dfs(result, new LinkedList(), 0, graph);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int i, int[][] graph) {
        list.add(i);
        if (i == graph.length - 1) {
            result.add(new LinkedList<>(list));
            return;
        }

        for (int j = 0; j < graph[i].length; j++) {
            dfs(result,list,graph[i][j],graph);
            list.remove(list.size() - 1);
        }
    }
}
