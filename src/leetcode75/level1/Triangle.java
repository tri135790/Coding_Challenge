package leetcode75.level1;

import java.util.List;

//TODO
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()];
        for (int i = triangle.size() - 1; i>=0; i--) {
            for (int j =0; j < triangle.get(i).size(); j++) {
                A[j] = Math.min(A[j], A[j+1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
