package leetcode75.level1.twopointers;

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK {



    public static int findSubarrays(int[] arr, int target) {
        int count = 0;
        double product = 1;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= target && left <= right)
                product /= arr[left++];

            for (int i = right; i >= left; i--) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] {4,3,2,4,3,8,3,3,6,2
            ,10,10,9,3}, 19));
    }
}
