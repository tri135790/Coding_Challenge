package leetcode75.level1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {

    private int V;


    private ArrayList<ArrayList<Integer>> adj;

    TopologicalSort(int v)
    {
        V = v;
        adj = new ArrayList<ArrayList<Integer> >(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<Integer>());
    }

    void addEdge(int v, int w) { adj.get(v).add(w); }

    void topologicalSortUtil(int v, boolean visited[],
                             Stack<Integer> stack)
    {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        stack.push(new Integer(v));
    }

    void topologicalSort()
    {
        Stack<Integer> stack = new Stack<Integer>();


        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;


        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);


        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");
    }

    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological "
            + "sort of the given graph");
        // Function Call
        g.topologicalSort();
    }
}
