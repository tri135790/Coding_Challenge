package leetcode75.level1.fastslowpointer;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static boolean find(int num) {
        int slow = 0;
        int fast = 0;

        while (fast != 1) {
            slow = calculate(slow);
            fast = calculate(calculate(fast));
            if (slow == fast) {
                return false;
            }
        }
        return true;
    }

    private static Integer calculate(int num) {
        int sum = 0;
        while (num != 0) {
            sum += Math.pow((num%10),2);
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}
