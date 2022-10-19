package leetcode75.level1.bitwiseXOR;

public class SingleNumber {

    public static int findSingleNumber(int[] arr) {

        int x1 = 0;
        for (int i : arr) {
            x1 = x1 ^ i;
        }
        return x1;
    }

    public static void main( String args[] ) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}
