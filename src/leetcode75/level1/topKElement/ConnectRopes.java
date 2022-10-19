package leetcode75.level1.topKElement;

import java.util.PriorityQueue;

public class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropeLengths) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : ropeLengths) {
            minHeap.add(n);
        }
        int sum = 0;

        while (minHeap.size() >= 2) {
            int rope1= minHeap.poll();
            int rope2 = minHeap.poll();
            minHeap.add(rope1 + rope2);
            sum += rope1 + rope2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}
