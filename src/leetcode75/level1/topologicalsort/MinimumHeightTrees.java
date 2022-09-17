package leetcode75.level1.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinimumHeightTrees {

    public static List<Integer> findTrees(int nodes, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();

        if (nodes == 1) {
            minHeightTrees.add(0);
            return minHeightTrees;
        }

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> incomingEdges = new HashMap<>();

        for (int i =0; i < nodes; i++) {
            graph.put(i, new ArrayList<>());
            incomingEdges.put(i,0);
        }


        for (int[] edge : edges) {
            int numb1 = edge[0];
            int numb2 = edge[1];

            graph.get(numb1).add(numb2);
            graph.get(numb2).add(numb1);

            incomingEdges.put(numb1, incomingEdges.get(numb1) + 1);
            incomingEdges.put(numb2, incomingEdges.get(numb2) + 1);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0 ; i < nodes; i++) {
            if (incomingEdges.get(i) == 1) {
                leaves.add(i);
            }
        }


        int totalNodes = nodes;
        while (totalNodes > 2) {
            int leavesSize = leaves.size();
            totalNodes = totalNodes - leavesSize;
            for (int i = 0; i < leavesSize; i++) {
                int vertex = leaves.poll();

                for (Integer child : graph.get(vertex)) {
                    incomingEdges.put(child, incomingEdges.get(child) - 1);
                    if (incomingEdges.get(child) == 1)
                        leaves.add(child);

                }
            }
        }



        minHeightTrees.addAll(leaves);
        return minHeightTrees;
    }

    public static void main(String[] args) {
        List<Integer> result = MinimumHeightTrees.findTrees(5,
            new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 } });
        System.out.println("Roots of MHTs: " + result);

        result = MinimumHeightTrees.findTrees(4,
            new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 } });
        System.out.println("Roots of MHTs: " + result);

        result = MinimumHeightTrees.findTrees(4,
            new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 } });
        System.out.println("Roots of MHTs: " + result);
    }
}
