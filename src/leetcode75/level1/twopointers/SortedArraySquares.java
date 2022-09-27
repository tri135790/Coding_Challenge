package leetcode75.level1.twopointers;

public class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int count = arr.length-1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int leftSquare = arr[left]*arr[left];
            int rightSquare = arr[right]*arr[right];
            if (leftSquare > rightSquare) {
                squares[count--] = leftSquare;
                left++;
            } else {
                squares[count--] = rightSquare;
                right--;
            }
        }

        return squares;
    }
}
