package leetcode75.level1;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1, b = 2;
        while (n-- > 2) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
