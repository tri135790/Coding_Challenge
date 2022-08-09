package leetcode75.level1;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        if (nums.length == 0) {
            return 0;
        }

        while (start <= end) {
            int pivot = start + (end - start)/2;
            if (target > nums[pivot]) {
                start = pivot + 1;
            } else if (target < nums[pivot]) {
                end = pivot - 1;
            } else {
                return pivot;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,5,6};

        System.out.println(searchInsert(nums, 7));
    }
}
