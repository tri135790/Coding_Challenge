package leetcode75.level1;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumber {

    public static int fib(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i =0; i <= n; i ++) {
            if (i == 0) {
                list.add(0);
                continue;
            }
            if (i == 1) {
                list.add(1);
                continue;
            }
            list.add(list.get(i-2) + list.get(i-1));
        }
        return list.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fib(3));
    }
}
