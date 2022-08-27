package leetcode75.level1;

public class CountNumberOfNiceSubarrays {

    public static int numberOfSubarrays2(int[] A, int k) {
        return atMost(A, k) - atMost(A, k - 1);
    }

    private static int atMost(int[] A, int k) {
        int start = 0;
        int res = 0;

        for (int end = 0; end < A.length; end++) {
            if ((A[end] % 2) == 1) {
                k--;
            }
            while (k < 0) {
                if ((A[start] % 2) == 1) {
                    k++;
                }
                start++;
            }
            res += end-start+1;
        }
        return res;
    }

    public static int numberOfSubarrays1(int[] A, int k) {
        int res = 0, i = 0, count = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            if (A[j] % 2 == 1) {
                --k;
                count = 0;
            }
            while (k == 0) {
                k += A[i++] & 1;
                ++count;
            }
            res += count;
        }
        return res;
    }


}
