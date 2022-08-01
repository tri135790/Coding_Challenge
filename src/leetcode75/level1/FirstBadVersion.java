package leetcode75.level1;

public class FirstBadVersion {

    public static int firstBadVersion(int n) {
        int pivot = 1;
        int head = 1;
        int tail = n;
        while (head <= tail) {
            pivot = head + (tail - head)/2;
            if (isBadVersion(pivot)) {
                tail = pivot -1;
            } else {
                head = pivot + 1;
            }
        }

        if (isBadVersion(pivot)) {
            return pivot ;
        }else {
            return pivot +1 ;
        }
    }

    private static boolean isBadVersion(int version) {
        return true;
    }
}
