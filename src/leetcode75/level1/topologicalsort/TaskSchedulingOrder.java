package leetcode75.level1.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TaskSchedulingOrder {

    public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        // TODO: Write your code here
        int[] incomingEdges = new int[tasks];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : prerequisites) {
            incomingEdges[edge[1]]++;

            if (!map.containsKey(edge[0])) {
                List<Integer> list = new LinkedList<>();
                list.add(edge[1]);
                map.put(edge[0],list);
            } else {
                map.get(edge[0]).add(edge[1]);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0 ; i < tasks; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            sortedOrder.add(current);

            if (map.containsKey(current)) {
                for (Integer i : map.get(current)) {
                    incomingEdges[i]--;
                    if (incomingEdges[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }

        return sortedOrder.size() == tasks ? sortedOrder : new LinkedList<>();
    }

    public static void main(String[] args) {
        List<Integer> result = TaskSchedulingOrder.findOrder(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(3,
            new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
            new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println(result);
    }
}
