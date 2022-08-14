package leetcode75.level1;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {

            List<Integer> curr = new ArrayList<>();
            for (int j = 1; j <= i; j ++) {
                if (j == 1 || j == i) {
                    curr.add(1);
                } else {
                    curr.add(list.get(i-1-1).get(j-1-1) + list.get(i-1-1).get(j-1));
                }
            }
            list.add(curr);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
