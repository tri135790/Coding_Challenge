package leetcode75.level1;

public class TriBonacciNumber {
    public int tribonacci(int n) {
        int[] list = new int[n+1];
        list[0] = 1;
        list[1] = 1;
        list[2] = 1;
        for (int i = 3; i <= n; i++) {
            list[i] = list[i-1] + list[i-2] + list[i-3];
        }
        return list[n];
    }
}
