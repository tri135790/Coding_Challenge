package leetcode75.level1;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {
            List<List<Integer>> list = new ArrayList<>();
            for (int i =1; i <= rowIndex + 1; i ++) {
                List<Integer> current = new ArrayList<>();
                for (int j = 1; j<= i; j++) {
                    if (j == 1 || j == i) {
                        current.add(1);
                    } else {
                        current.add(list.get(i-1-1).get(j-1-1) + list.get(i-1-1).get(j-1));
                    }
                }
                list.add(current);
            }
            return list.get(rowIndex+1);
    }
}
