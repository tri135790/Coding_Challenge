package leetcode75.level1.kwaymerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LargestPairs {

    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();

        int count = 0;
        int n1 =0, n2 =0;

        while (count < k) {
            int cur1 = nums1[n1];
            int cur2 = nums2[n2];
            result.add(new int[]{cur1, cur2});

            if (cur1 - nums1[n1 + 1] <= cur2 - nums2[n2 + 1]) {
                n1++;
            } else {
                n2++;
            }
            count++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 9, 8, 2 };
        int[] l2 = new int[] { 6, 3, 1 };
        List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
    }
}
