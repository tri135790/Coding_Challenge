package leetcode75.level1.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0 ; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i-1]) {
                continue;
            }
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) // skip same element to avoid duplicate quadruplets
                    continue;
                searchPair(arr, target, i, j, quadruplets);
            }
        }
        return quadruplets;
    }



    private static void searchPair(int[] arr, int target, int first,int second,
                                   List<List<Integer>> quadruplets) {
        int left = second+1;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[first] + arr[second] + arr[left] + arr[right];
            if (sum == target) {
                quadruplets.add(Arrays.asList(arr[left], arr[right], arr[first], arr[second ]));
                left++;
                right--;
                while(left < right && arr[left] == arr[left - 1]) left++;
                while(left < right && arr[right] == arr[right + 1]) right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
    }
}
