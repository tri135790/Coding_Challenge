package leetcode75.level1.modifiedbinarysearch;

public class FindRange {

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };

        int start = 0, end = arr.length -1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (arr[mid] == key) {
                int left = mid, right = mid;
                while (arr[left-1]  == key) {
                    left--;
                }
                while (arr[right+1] == key) {
                    right++;
                }
                result[0] = left;
                result[1] = right;
                return result;
            }

            if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
