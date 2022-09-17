package leetcode75.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SequenceReconstructionSolution2 {

    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (originalSeq.length <= 0)
            return false;

        // a. Initialize the graph
        HashMap<Integer, Integer> incomingEdges = new HashMap<>(); // count of incoming edges for
        // every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for (int[] seq : sequences) {
            for (int i = 0; i < seq.length; i++) {
                incomingEdges.putIfAbsent(seq[i], 0);
                graph.putIfAbsent(seq[i], new ArrayList<>());
            }
        }

        // b. Build the graph
        for (int[] seq : sequences) {
            for (int i = 1; i < seq.length; i++) {
                int parent = seq[i - 1], child = seq[i];
                graph.get(parent).add(child);
                incomingEdges.put(child, incomingEdges.get(child) + 1);
            }
        }

        // if we don't have ordering rules for all the numbers we'll not able to uniquely construct the sequence
        if (incomingEdges.size() != originalSeq.length)
            return false;

        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : incomingEdges.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            if (sources.size() > 1)
                return false; // more than one sources mean, there is more than one way to reconstruct the sequence
            if (originalSeq[sortedOrder.size()] != sources.peek())
                return false; // the next source (or number) is different from the original sequence
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
            for (int child : children) {
                incomingEdges.put(child, incomingEdges.get(child) - 1);
                if (incomingEdges.get(child) == 0)
                    sources.add(child);
            }
        }

        // if sortedOrder's size is not equal to original sequence's size, there is no unique way to construct
        return sortedOrder.size() == originalSeq.length;
    }

    public static void main(String[] args) {
        boolean result = SequenceReconstructionSolution2.canConstruct(new int[] { 1, 2, 3, 4 },
            new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstructionSolution2.canConstruct(new int[] { 1, 2, 3, 4 },
            new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstructionSolution2.canConstruct(new int[] { 3, 1, 4, 2, 5 },
            new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
        System.out.println("Can we uniquely construct the sequence: " + result);
    }
}
