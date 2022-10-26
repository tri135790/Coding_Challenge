package leetcode75.level1.dynamicprogramming;

public class ArrayJump {

    public int countMinJumps(int[] jumps) {
        int[] dp = new int[jumps.length];
        return recursive(dp, jumps, 0);
    }

    private int recursive(int[] dp, int[] jumps, int currentIndex) {
        if (currentIndex == jumps.length - 1) {
            return 0;
        }

        if (jumps[currentIndex] == 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[currentIndex] != 0) {
            return dp[currentIndex];
        }

        int start = currentIndex + 1;
        int end = currentIndex + jumps[currentIndex];
        int totalJump = Integer.MAX_VALUE;

        while (start < jumps.length && start <= end) {
            int minJump = recursive(dp, jumps, start);
            start++;
            if (minJump != Integer.MAX_VALUE) {
                totalJump = Math.min(totalJump, minJump + 1);
            }
        }
        dp[currentIndex] = totalJump;
        return dp[currentIndex];
    }

    public static void main(String[] args) {
        ArrayJump aj = new ArrayJump();
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumps(jumps));
    }
}
