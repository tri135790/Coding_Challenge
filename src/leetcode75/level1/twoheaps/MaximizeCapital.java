package leetcode75.level1.twoheaps;

import java.util.PriorityQueue;

public class MaximizeCapital {

    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {

        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(capital.length,
            (a,b) -> capital[a] - capital[b]);
        PriorityQueue<Integer> maxCapitalHeap = new PriorityQueue<>(profits.length,
            (a,b) -> profits[b] - profits[a]);

        for(int i =0; i < capital.length; i++) {
            minCapitalHeap.add(i);
        }

        int maxCapital = initialCapital;

        for (int i = 0; i < numberOfProjects; i++) {

            while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= maxCapital) {
                maxCapitalHeap.add(minCapitalHeap.poll());
            }

            if (maxCapitalHeap.isEmpty()) break;

            maxCapital += profits[maxCapitalHeap.poll()];
        }


        return maxCapital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}
