package leetcode75.level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new LinkedList<>(), 0, k,n);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list,int sum,
                           int k,
                           int n) {
        if (list.size() == k) {
            if (sum == n && !checkAlreadyExist(res, list)) {
                res.add(new LinkedList<>(list));
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (sum + i <= n && !list.contains(i)) {
                list.add(i);
                sum += i;
                backtrack(res, list, sum, k, n);
                list.remove(list.size() - 1);
                sum -= i;
            }
        }
    }

    private boolean checkAlreadyExist(List<List<Integer>> res, List<Integer>list) {
        for (List<Integer> i : res) {
            if (i.containsAll(list)) {
                return true;
            }
        }
        return false;
    }

    public static List<List<Integer>> combinationSum(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        combination(res, new LinkedList<>(),  k, 1 ,n);
        return res;
    }

    private static void combination(List<List<Integer>> res, List<Integer> list, int k, int start,
                              int n) {
        if (list.size() == k && n == 0 ) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = start; i <=9; i++) {
            list.add(i);
            combination(res, list, k, i + 1, n - i);
            list.remove(list.size()-1);
        }
    }


    public static void main(String[] args) {
        System.out.println(combinationSum(3, 18));

    }
}
