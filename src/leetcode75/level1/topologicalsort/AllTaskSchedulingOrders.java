package leetcode75.level1.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllTaskSchedulingOrders {

    public static void printOrders(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();

        int[] incomingEdges = new int[tasks];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < tasks; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            incomingEdges[edge[1]]++;

            map.get(edge[0]).add(edge[1]);

        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < tasks; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }

        printAllTopologicalSort(map, incomingEdges, queue, sortedOrder);

    }

    private static void printAllTopologicalSort(
        HashMap<Integer, List<Integer>> map,
        int[] incomingEdges, Queue<Integer> queue,
        List<Integer> sortedOrder
    ) {
        if (!queue.isEmpty()) {
            for (Integer current : queue) {
                sortedOrder.add(current);
                Queue<Integer> clone = cloneQueue(queue);
                clone.remove(current);
                for (int children : map.get(current)) {
                    incomingEdges[children]--;
                    if (incomingEdges[children] == 0) {
                        clone.add(children);
                    }
                }
                printAllTopologicalSort(map, incomingEdges, clone, sortedOrder);
                sortedOrder.remove(current);
                for (int children : map.get(current)) {
                    incomingEdges[children]++;
                }
            }
        }

        if (sortedOrder.size() == incomingEdges.length)
            System.out.println(sortedOrder);
    }

    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue)
            clone.add(num);
        return clone;
    }

    public static void main(String[] args) {
        AllTaskSchedulingOrders.printOrders(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}});
        System.out.println();

        AllTaskSchedulingOrders.printOrders(4,
            new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}}
        );
        System.out.println();

        AllTaskSchedulingOrders.printOrders(6,
            new int[][]{new int[]{2, 5}, new int[]{0, 5}, new int[]{0, 4},
                new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}}
        );
        System.out.println();
    }
}
