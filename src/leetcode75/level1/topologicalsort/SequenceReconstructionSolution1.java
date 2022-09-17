package leetcode75.level1.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SequenceReconstructionSolution1 {

    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {

        //initialize the graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> incomingEdges = new HashMap<>();
        for (Integer number : originalSeq) {
            incomingEdges.put(number, 0);
            graph.put(number, new LinkedList<>());
        }

        //build the graph
        for (int[] pair : sequences) {
            for (int i = 0 ; i < pair.length - 1; i++) {
                incomingEdges.put(pair[i + 1], incomingEdges.get(pair[i + 1]) + 1);
                graph.get(pair[i]).add(pair[i + 1]);
            }
        }

        //Using queue
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer>  set : incomingEdges.entrySet()) {
            if (set.getValue() == 0) {
                queue.add(set.getKey());
            }
        }

        //Find all topological Orders
        List<List<Integer>> allSequences = new ArrayList<>();
        List<Integer> tempoSequence = new ArrayList<>();
        backtrack(allSequences, tempoSequence, graph, incomingEdges, queue);

        return allSequences.size() == 1;
    }

    private static void backtrack(
        List<List<Integer>> allSequences,
        List<Integer> tempoSequence,
        HashMap<Integer, List<Integer>> graph,
        HashMap<Integer, Integer> incomingEdges,
        Queue<Integer> queue
    ) {
        if (!queue.isEmpty()) {
            for (Integer current : queue) {
                tempoSequence.add(current);
                Queue<Integer> clone = cloneQueue(queue);
                clone.remove(current);

                for (int children : graph.get(current)) {
                    incomingEdges.put(children, incomingEdges.get(children) - 1);
                    if (incomingEdges.get(children) == 0) {
                        clone.add(children);
                    }
                }
                backtrack(allSequences, tempoSequence, graph, incomingEdges, clone);
                tempoSequence.remove(current);

                for (int children : graph.get(current)) {
                    incomingEdges.put(children, incomingEdges.get(children) + 1);
                }
            }
        }

        if (tempoSequence.size() == incomingEdges.size()) {
            allSequences.add(new LinkedList<>(tempoSequence));
        }
    }

    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue)
            clone.add(num);
        return clone;
    }

    public static void main(String[] args) {
        boolean result = SequenceReconstructionSolution1.canConstruct(new int[] { 1, 2, 3, 4 },
            new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstructionSolution1.canConstruct(new int[] { 1, 2, 3, 4 },
            new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstructionSolution1.canConstruct(new int[] { 3, 1, 4, 2, 5 },
            new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
        System.out.println("Can we uniquely construct the sequence: " + result);
    }
}
