package leetcode75.level1;

import java.util.ArrayList;
import java.util.List;
//TODO
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list1 = new ArrayList<>();
        list1.add("()");
        List<String> list2 = new ArrayList<>();
        list2.add("(())");
        list2.add("()()");

        if (n == 1) return list1;
        if (n== 2) return list2;
        List<List<String>> dp = new ArrayList<>();
        dp.add(list1);
        dp.add(list2);

        for (int i = 3; i <= n; i++) {
            List<String> list = new ArrayList<>();
            for (int j =0; j < dp.get(i - 2).size(); j++) {
                if (j != dp.get(i-2).size() - 1) {
                    list.add("(" + dp.get(i-2).get(j) + ")");
                    list.add("()" + dp.get(i-2).get(j));
                    list.add(dp.get(i-2).get(j) + "()");
                } else {
                    list.add("(" + dp.get(i-2).get(j) + ")");
                    list.add(dp.get(i-2).get(j) + "()");
                }
            }
            dp.add(list);
        }
        return dp.get(n-1);
    }
}
