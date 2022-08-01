package leetcode75.level1;

public class BinarySearch {

    public static int search(int[] nums, int target) {
        int pivot;
        int head = 0; //0
        int tail = nums.length -1; //5
        while (head <= tail) {
            pivot = head + (tail-head)/2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] < target) {
                head = pivot + 1;
            } else {
                tail = pivot - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
    }
}
